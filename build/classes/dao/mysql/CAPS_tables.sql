DROP SCHEMA capsdb;

CREATE SCHEMA capsdb ;

CREATE TABLE capsdb.lecturer
(
      lecturerID 		bigint 			NOT NULL,
      lastName 			nvarchar(255),
      firstMidName 		nvarchar(255),
      email				nvarchar(255),
      password 			nvarchar(255),
PRIMARY KEY(lecturerID)
);

CREATE TABLE capsdb.student
(
      studentID 		bigint 			NOT NULL,
      lastName 			nvarchar(255),
      firstMidName 		nvarchar(255),
      enrolmentDate		date,
      email				nvarchar(255),
      password 			nvarchar(255),
PRIMARY KEY(studentID)
);

CREATE TABLE capsdb.admin
(
      adminID 			bigint 			NOT NULL,
      password 			nvarchar(255),
PRIMARY KEY(adminID)
);

CREATE TABLE capsdb.course
(
      courseID 			bigint 			NOT NULL,
      courseName 		nvarchar(255),
      size				bigint,
      credits			bigint,
      lecturerID		bigint,
      startDate			date,
      endDate			date,
PRIMARY KEY(courseID),
FOREIGN KEY(lecturerID)
	REFERENCES capsdb.lecturer(lecturerID)
    ON DELETE SET NULL
);

CREATE TABLE capsdb.enrolment
(
	studentID			bigint			NOT NULL,
    courseID			bigint			NOT NULL,
PRIMARY KEY(studentID, courseID),
FOREIGN KEY(studentID)
	REFERENCES capsdb.student(studentID),
FOREIGN KEY(courseID)
	REFERENCES capsdb.course(courseID)
    ON DELETE CASCADE
);

CREATE TABLE capsdb.completed
(
	studentID			bigint			NOT NULL,
    courseID			bigint			NOT NULL,
    grade				bigint,
PRIMARY KEY(studentID, courseID),
FOREIGN KEY(studentID)
	REFERENCES capsdb.student(studentID),
FOREIGN KEY(courseID)
	REFERENCES capsdb.course(courseID)
    ON DELETE CASCADE
);