package com.hxb.contentcenter.service;

import com.hxb.contentcenter.dao.share.ShareMapper;
import com.hxb.contentcenter.domain.dto.content.ShareDTO;
import com.hxb.contentcenter.domain.dto.messaging.UserAddBonusMsgDTO;
import com.hxb.contentcenter.domain.dto.user.UserDTO;
import com.hxb.contentcenter.domain.entity.content.Share;
import com.hxb.contentcenter.feignclinet.UserConterFeignClinet;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserConterFeignClinet userConterFeignClinet;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    //@Autowired
    //private RestTemplate restTemplate;

    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        List<String> urlList = instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .collect(Collectors.toList());
        int i = ThreadLocalRandom.current().nextInt(urlList.size());
        String url = urlList.get(i);
        log.info("url==" + url);*/
        //UserDTO userDTO = restTemplate.getForObject("http://user-center/users/{userId}",
        //        UserDTO.class, userId);

        // 1. 代码不可读
        // 2. 复杂的url难以维护：https://user-center/s?ie={ie}&f={f}&rsv_bp=1&rsv_idx=1&tn=baidu&wd=a&rsv_pq=c86459bd002cfbaa&rsv_t=edb19hb%2BvO%2BTySu8dtmbl%2F9dCK%2FIgdyUX%2BxuFYuE0G08aHH5FkeP3n3BXxw&rqlang=cn&rsv_enter=1&rsv_sug3=1&rsv_sug2=0&inputT=611&rsv_sug4=611
        // 3. 难以相应需求的变化，变化很没有幸福感
        // 4. 编程体验不统一
        //UserDTO userDTO = this.userCenterFeignClient.findById(userId);
        UserDTO userDTO = userConterFeignClinet.findById(userId);
        ShareDTO shareDTO = new ShareDTO();

        rocketMQTemplate.convertAndSend("my-group", UserAddBonusMsgDTO.builder()
                .userId(share.getUserId())
                .bonus(50)
                .build());

        // 消息的装配
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        // 用HTTP GET方法去请求，并且返回一个对象
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:8080/users/{id}",
                String.class, 1
        );

        System.out.println(forEntity.getBody());
        System.out.println(forEntity.getStatusCode());
    }

    public List<String> getInstances() {
        return discoveryClient.getServices();
    }


}

