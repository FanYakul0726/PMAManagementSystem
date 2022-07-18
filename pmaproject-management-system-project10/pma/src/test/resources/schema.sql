CREATE SEQUENCE IF NOT EXISTS student_seq;

CREATE TABLE IF NOT EXISTS student (

    student_id BIGINT NOT NULL DEFAULT nextval('student_seq') PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    wechat_id VARCHAR(100) NOT NULL

    );

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (

    project_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    stage VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL

    );


CREATE TABLE IF NOT EXISTS project_student (

                                               project_id BIGINT REFERENCES project,
                                               student_id BIGINT REFERENCES student

);