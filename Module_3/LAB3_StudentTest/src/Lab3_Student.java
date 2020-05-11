public class Lab3_Student {
    public static void main(String[] args) {
/*        create database lab3_studentTest;

        use lab3_studentTest;

        -- Tao bang Class
        create table Class (
                ClassID int not null auto_increment primary key,
                ClassName nvarchar(50) not null,
                StartDate datetime not null,
                Status bit
);

        -- Tao bang Student
        create table Student (
                StudentID int not null primary key,
        StudentName nvarchar(30) not null,
                Address nvarchar(50) default null,
                Phone varchar(2) default null,
                Status bit default null,
                ClassID int not null
);

        -- Tao Bang Subject
        create table Subject (
                SubID int not null auto_increment primary key,
                SubName nvarchar(30) not null,
                Credit tinyint not null default 1 check(Credit >= 1),
                Status bit default 1
);

        -- Tao bang Mark
        create table Mark (
                MarkID int not null auto_increment primary key,
                SubID int not null unique,
                StudentID int not null unique,
                Mark float default 0 check(Mark >= 0 and mark <= 100),
                ExamTimes tinyint default 1
);

        -- Thêm ràng buộc khóa ngoại trên cột ClassID của  bảng Student,
        -- tham chiếu đến cột ClassID trên bảng Class.
                alter table Student add foreign key (ClassID) references Class(ClassID);

        -- Thêm ràng buộc cho cột StartDate của  bảng Class là ngày hiện hành
        alter table Class modify column StartDate datetime default current_date();

        -- Thêm ràng buộc mặc định cho cột Status của bảng Student là 1.
        alter table Student modify column Status bit default 1;

        -- Thêm ràng buộc khóa ngoại cho bảng Mark trên cột:
        -- SubID trên bảng Mark tham chiếu đến cột SubID trên bảng Subject
                -- StudentID tren bảng Mark tham chiếu đến cột StudentID của bảng Student.
        alter table Mark add foreign key (SubID) references Subject(SubID);
        alter table Mark add foreign key(StudentID) references Student(StudentID);

        -- Them Du lieu vao bang Class
        insert into Class(ClassName, StartDate, Status) values
                ('A1', '2008-12-20', 1),
                ('A2', '2008-12-22', 1);

        insert into Class(ClassName, Status) values('B3', 0);

        -- Them Du lieu vao bang Student
        insert into Student(StudentID, StudentName, Address, Phone, Status, ClassID)
        values
                (1, 'Hung', 'Ha Noi', '0912113113', 1, 1),
                (2, 'Hoa', 'Hai Phong', null, 1, 1),
        (3, 'Manh', 'HCM', '0123123123', 0, 2);

        -- -- Them Du lieu vao bang Subject
        insert into Subject(SubName, Credit) values
                ('CF', 5),
                ('C', 6),
        ('HDJ', 5),
        ('RDBMS', 10);

        -- -- Them Du lieu vao bang Mark
        insert into Mark(SubID, StudentID, Mark, ExamTimes)
        values
                (1,1,8,1),
                (1,2,10,2),
        (2,1,12,1);

        alter table Mark add foreign key (SubID) references Subject(SubID);
        alter table Mark add foreign key (StudentID) references Student(StudentID);

        -- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
        update Student set ClassID = 2 where StudentName = 'Hung';

        -- Cập nhật cột phone trên bảng sinh viên
                -- là ‘No phone’ cho những sinh viên chưa có số điện thoại.
                update Student set Phone = 'No Phone' where Phone is null or Phone = '';

        -- Nếu trạng thái của lớp (Stutas) là 0 thì thêm từ ‘New’ vào trước tên lớp.
        -- (Chú ý: phải sử dụng phương thức write).
        update Class set ClassName = concat('New', ClassName) where Status = 0;

        -- Nếu trạng thái của status trên bảng Class
                -- là 1 và tên lớp bắt đầu là ‘New’ thì thay thế ‘New’ bằng ‘old’.
        update Class set ClassName = replace(ClassName, 'New', 'old') where Status = 1 and ClassName like 'New%';

        -- Nếu lớp học chưa có sinh viên thì thay thế trạng thái là 0 (status=0).
                update Class set Status = 0 where ClassID in (select ClassID from Student);

        -- Cập nhật trạng thái của lớp học (bảng subject) là 0 nếu môn học đó
        -- chưa có sinh viên dự thi.
                update Subject set Status = 0 where SubId not in (select SubID from Mark);

        -- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’.
        select StudentName from Student where StudentName like 'h%';

        -- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
        select ClassName from Class where StartDate like '%-12-%';

        -- Hiển thị giá trị lớn nhất của credit trong bảng subject.
        select max(Credit) from Subject;

        -- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
        select * from Subject where Credit = (select max(Credit) from Subject);

        -- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
        select * from Subject where Credit >= 3 and Credit <= 5;

        -- Hiển thị các thông tin bao gồm: classid, className, studentname, Address từ hai bảng Class, student
        select c.ClassID, c.ClassName, s.StudentName, s.Address from Class as c inner join Student as s using(ClassID);

        -- Hiển thị các thông tin môn học chưa có sinh viên dự thi.
        select Subject.SubID from Subject left join Mark using (SubID) where SubID not in (select SubID from Mark);

        -- Hiển thị các thông tin môn học có điểm thi lớn nhất
        select s.SubID, s.SubName, s.Credit, s.Status from Mark as m inner join Subject as s using(SubID) where m.Mark = (select max(Mark) from Mark);

        -- Hiển thị các thông tin sinh viên và điểm trung bình tương ứng.
        select s.StudentID, s.StudentName, avg(Mark) as AVG from Student as s inner join Mark as m using(StudentID) group by StudentID;

        -- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần (gợi ý: sử dụng hàm rank)
        select s.StudentID, s.StudentName, avg(Mark) as AVG from Student as s inner join Mark as m using(StudentID) group by StudentID order by avg(Mark) desc;

        -- Hiển thị các thông tin sinh viên và điểm trung bình, chỉ đưa ra các sinh viên có điểm trung bình lớn hơn 10.
        select s.StudentID, s.StudentName, avg(Mark) as AVG from Student as s inner join Mark as m using(StudentID) group by StudentID having avg(Mark) >= 10 order by avg(Mark) desc;

        -- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
                select s.StudentName, sub.SubName, sum(Mark) from Student as s inner join Mark as m using(StudentID) inner join Subject as sub using(SubID) group by StudentName order by sum(Mark) desc;

        -- Xóa tất cả các lớp có trạng thái là 0.
        delete from Class where Status = 0;

        -- Xóa tất cả các môn học chưa có sinh viên dự thi.
                delete from Subject where SubID in (select SubID from Subject where SubID not in (select SubID from Mark));

        -- Xóa bỏ cột ExamTimes trên bảng Mark.
        alter table Mark drop column ExamTimes;

        -- Sửa đổi cột status trên bảng class thành tên ClassStatus.
        alter table Class change Status ClassStatus bit;

        -- Sửa đổi cột status trên bảng class thành tên ClassStatus.
        rename table Mark to SubjectTest;

        -- create new Database
        create database newDatabase;

        -- Xoa Database
        drop database newDatabase*/;
    }
}
