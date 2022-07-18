insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '赖波弛', 'Warton', 'warton@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '毕咏湛', 'Lanister', 'lanister@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '孙斐恋', 'Reeves', 'Reeves@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '成骥坤', 'Connor', 'connor@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '单琦习', 'Salvator', 'Sal@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '单仪柳', 'Henley', 'henley@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '翁列标', 'Carson', 'carson@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '支奕辰', 'Miles', 'miles@gmail.com');
insert into student (student_id, name, wechat_id, email) values (nextval('student_seq'), '伍柳妍', 'Roggers', 'roggers@gmail.com');

-- 插入项目
insert into project (project_id, name, stage, description) values (nextval('project_seq'), '大规模生产部署', '未开始', '这需要所有的人都参与到软件的最终部署生产中来。');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), '学习微服务架构',  '已完成', '通过微服务，可将大型应用分解成多个独立的组件，其中每个组件都有各自的责任领域。');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), '软件测试', '进行中', '在规定的条件下对程序进行操作，以发现程序错误，衡量软件质量。');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), '毕业设计规划', '进行中', '独立完成一个应用软件或较大软件中的一个或数个模块设计、调试');

-- 插入PROJECT_STUDENT_关系
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Warton' AND p.name = '大规模生产部署');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Warton' AND p.name = '学习微服务架构');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Warton' AND p.name = '软件测试');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Reeves' AND p.name = '大规模生产部署');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Warton' AND p.name = '学习微服务架构');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Warton' AND p.name = '毕业设计规划');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Henley' AND p.name = '软件测试');
insert into project_student (student_id, project_id) (select s.student_id, p.project_id from student s, project p where wechat_id ='Henley' AND p.name = '毕业设计规划');