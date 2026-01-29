create table if not exists user
(
    id          int auto_increment comment '用户唯一ID'
        constraint `PRIMARY`
        primary key,
    name        varchar(50)   not null comment '用户名',
    password    varchar(100)  not null comment '密码（建议加密存储）',
    select_id   int default 0 not null comment '选择的题库',
    create_time datetime      null comment '创建时间',
    access      varchar(50)   null comment '访问权限'
)
    auto_increment = 6;

create table if not exists repository
(
    id              int auto_increment comment '题库唯一ID'
        constraint `PRIMARY`
        primary key,
    repository_name varchar(100)  not null comment '题库名称',
    mode            int default 0 null comment '题库模式（如：0/1）0顺序，1随机',
    user_id         int           not null comment '所属用户ID（关联user表）',
    description     varchar(100)  null comment '题库描述',
    constraint repository_ibfk_1
        foreign key (user_id) references user (id)
            on update cascade
)
    auto_increment = 49;

create table if not exists question
(
    id            int auto_increment comment '题目唯一ID'
        constraint `PRIMARY`
        primary key,
    topic         varchar(200) not null comment '题目题干',
    answer        char         not null comment '正确答案',
    options       varchar(500) null comment '选择题选项（用逗号/JSON分隔，如：A.xxx,B.xxx）',
    repository_id int          not null comment '所属题库ID（关联repository表）',
    constraint question_ibfk_1
        foreign key (repository_id) references repository (id)
            on update cascade on delete cascade
)
    auto_increment = 64;

create index idx_que_repo
    on question (repository_id);

create index idx_repo_user
    on repository (user_id);


