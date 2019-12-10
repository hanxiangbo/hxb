package com.hxb.usercenter.domain.entity.user;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "user")
public class User {
    @Id
    @Column(name = "User")
    private String user;

    @Column(name = "Host")
    private String host;

    @Column(name = "Select_priv")
    private String selectPriv;

    @Column(name = "Insert_priv")
    private String insertPriv;

    @Column(name = "Update_priv")
    private String updatePriv;

    @Column(name = "Delete_priv")
    private String deletePriv;

    @Column(name = "Create_priv")
    private String createPriv;

    @Column(name = "Drop_priv")
    private String dropPriv;

    @Column(name = "Reload_priv")
    private String reloadPriv;

    @Column(name = "Shutdown_priv")
    private String shutdownPriv;

    @Column(name = "Process_priv")
    private String processPriv;

    @Column(name = "File_priv")
    private String filePriv;

    @Column(name = "Grant_priv")
    private String grantPriv;

    @Column(name = "References_priv")
    private String referencesPriv;

    @Column(name = "Index_priv")
    private String indexPriv;

    @Column(name = "Alter_priv")
    private String alterPriv;

    @Column(name = "Show_db_priv")
    private String showDbPriv;

    @Column(name = "Super_priv")
    private String superPriv;

    @Column(name = "Create_tmp_table_priv")
    private String createTmpTablePriv;

    @Column(name = "Lock_tables_priv")
    private String lockTablesPriv;

    @Column(name = "Execute_priv")
    private String executePriv;

    @Column(name = "Repl_slave_priv")
    private String replSlavePriv;

    @Column(name = "Repl_client_priv")
    private String replClientPriv;

    @Column(name = "Create_view_priv")
    private String createViewPriv;

    @Column(name = "Show_view_priv")
    private String showViewPriv;

    @Column(name = "Create_routine_priv")
    private String createRoutinePriv;

    @Column(name = "Alter_routine_priv")
    private String alterRoutinePriv;

    @Column(name = "Create_user_priv")
    private String createUserPriv;

    @Column(name = "Event_priv")
    private String eventPriv;

    @Column(name = "Trigger_priv")
    private String triggerPriv;

    @Column(name = "Create_tablespace_priv")
    private String createTablespacePriv;

    @Column(name = "ssl_type")
    private String sslType;

    @Column(name = "max_questions")
    private Integer maxQuestions;

    @Column(name = "max_updates")
    private Integer maxUpdates;

    @Column(name = "max_connections")
    private Integer maxConnections;

    @Column(name = "max_user_connections")
    private Integer maxUserConnections;

    private String plugin;

    @Column(name = "password_expired")
    private String passwordExpired;

    @Column(name = "password_last_changed")
    private Date passwordLastChanged;

    @Column(name = "password_lifetime")
    private Short passwordLifetime;

    @Column(name = "account_locked")
    private String accountLocked;

    @Column(name = "Create_role_priv")
    private String createRolePriv;

    @Column(name = "Drop_role_priv")
    private String dropRolePriv;

    @Column(name = "Password_reuse_history")
    private Short passwordReuseHistory;

    @Column(name = "Password_reuse_time")
    private Short passwordReuseTime;

    @Column(name = "Password_require_current")
    private String passwordRequireCurrent;

    @Column(name = "ssl_cipher")
    private byte[] sslCipher;

    @Column(name = "x509_issuer")
    private byte[] x509Issuer;

    @Column(name = "x509_subject")
    private byte[] x509Subject;

    @Column(name = "authentication_string")
    private String authenticationString;
}