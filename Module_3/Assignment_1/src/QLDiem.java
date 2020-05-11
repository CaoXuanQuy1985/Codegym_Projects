public class QLDiem {
    public static void main(String[] args) {
 /*       create database assignmentDB_1;

        create database QLDiem;

        use assignmentDB_1;

        create table if not exists Student(
                RN int(11) not null,
                Name varchar(50) not null,
                Age tinyint not null,
                Gender bit default 1
);

        create table Subject(
                sID int(11) not null,
                sName varchar(50) not null
);

        create table StudentSubject(
                RN int(11) not null,
                SID int(11) not null,
                Mark float not null
);

        alter table Student add primary key (RN);

        alter table Subject add primary key (sID);

        alter table StudentSubject add primary key(RN, sID);

        alter table StudentSubject modify column Mark float not null check(Mark >= 0 and Mark <= 10);

        alter table StudentSubject add foreign key(RN) references Student(RN);

        alter table StudentSubject add column Date date;

        alter table StudentSubject modify SID varchar(50) not null;

        alter table Subject modify SID varchar(50) not null;

        alter table Subject add primary key(SID);

        alter table StudentSubject add primary key(RN,SID);

        alter table StudentSubject add foreign key(RN) references Student(RN);

        alter table Student modify column RN int(11) not null auto_increment primary key;

        alter table StudentSubject modify column RN int(11) not null auto_increment primary key;

        alter table StudentSubject add foreign key(RN) references Student(RN);

        alter table StudentSubject add foreign key(SID) references Subject(SID);

        insert into Student(Name, Age, Gender) values('Mỹ Linh', 1, 1);

        insert into Subject(SID, SName) values('SQL', 'String Query Language');

        insert into StudentSubject(RN,SID, Mark, Date) values(1,'SQL', 8, '2005/07/28');

        insert into Student(Name, Age, Gender) values('Đàm Vĩnh Hưng', 1, 1);

        insert into Subject(SID, SName) values('LGC', 'LGC');

        insert into StudentSubject(RN,SID, Mark, Date) values(2,'LGC', 3, '2005/07/29');

        insert into Student(Name, Age, Gender) values('Kim Tử Long', 1, 1);

        insert into Subject(SID, SName) values('HTML', 'HTML');

        insert into StudentSubject(RN,SID, Mark, Date) values(3,'HTML', 9, '2005/07/31');

        insert into Student(Name, Age, Gender) values('Tài Linh', 1, 1);


        insert into StudentSubject(RN,SID, Mark, Date) values(4,'SQL', 5, '2005/07/30');

        insert into Student(Name, Age, Gender) values('Mỹ Lệ', 1, 1);

        insert into Subject(SID, SName) values('CF', 'CF');

        insert into StudentSubject(RN,SID, Mark, Date) values(5,'CF', 10, '2005/07/19');

        insert into Student(Name, Age, Gender) values('Ngọc Anh', 1, 1);

        insert into StudentSubject(RN,SID, Mark, Date) values(6,'SQL', 9, '2005/07/25');

        insert into Subject(SID, SNAME) values('CJ', 'CJ'), ('VB', 'Visual Basci');

        alter table StudentSubject add foreign key (SID) references Subject(SID);

        alter table Student modify column RN int(11) not null auto_increment primary key;

        alter table StudentSubject add foreign key (RN) references Student(RN);

        -- Hiển Thị tất cả các môn học mà chưa có học viên nào nhận điểm
        select SID, sName from Subject where SID not in (select SID from StudentSubject);

        -- Hiển thị danh sách tất cả các môn học, với điểm cao nhất mà học viên đạt được với môn
        -- học đó, môn nào chưa có điểm thì để trống (Null) phần điểm.
        select Subject.SID, Subject.sName, max(StudentSubject.Mark) from Subject left join StudentSubject using(SID) group by Subject.SID;

        -- Hiển thị tên môn học mà có nhiều hơn một điểm
        select Subject.sName, count(StudentSubject.Mark) from StudentSubject inner join Subject using(SID) group by StudentSubject.SID;

        alter table Student
        modify column Gender varchar(10);

        -- Đối với trường Gender hiển thị Male thay cho 0, Female thay cho 1 và Unknow thay cho Null
        update StudentInfo_2 set Gender =
        case
                when Gender = '0' then 'Male'
        when Gender = '1' then 'Female'
    else 'Unknow'
        end
        where RN in (1,2,3,4,5,6);

        -- Tạo một view tên là StudentInfo để xem đầy đủ các thông tin về học viên gồm
        -- (RN,sID,Name, Age, Gender, sName, Mark, Date).
        create view StudentInfo_2 as
        select s.RN, ss.SID, sub.sName, s.Name, s.Age, s.Gender, ss.Mark, ss.Date  from Student as s inner join StudentSubject as ss using(RN)
                inner join Subject as sub using(SID);

        select * from StudentInfo_2;

        select * from StudentInfo;

        select Name, max(Mark) from StudentInfo_2;

        select RN from StudentSubject inner join Student using(RN) where Name = 'Đàm Vĩnh Hưng';

        -- Tao Index tren 2 truong RN, SID:
        create index ind_view on StudentSubject(RN,SID);

        -- Viết một Store Procedure nhận vào một 2 tham số, tham số thứ nhất là tên học viên, tham
                -- số thứ 2 là điểm. Procedure này sẽ xóa toàn bộ các thông tin liên quan đến học viên có
                -- tên được cung cấp nếu tất cả các điểm của học viên đó đều nhỏ hơn tham số thứ 2.
                -- Trường hợp tham số thứ nhất là dấu * thì procedure sẽ xóa tất cả các học viên.
                use assignmentDB_1;
        delimiter //
        drop procedure if exists removeStudent //
        create procedure removeStudent(in nameStudent varchar(50), in score float)
        begin
        if (score > (select s.Mark from StudentInfo_2 as s where Name = nameStudent)) then
        delete from Student where RN = (select RN from StudentSubject inner join Student using(RN) where Name = nameStudent);
        end if;

        if (nameStudent = '*') then
        if (score > (select Name, max(Mark) from StudentInfo_2)) then
        truncate table StudentInfo_2;
        end if ;
        end if ;
        end //
                delimiter ;

        call removeStudent('Đàm Vĩnh Hưng', 10);

        select RN from StudentSubject inner join Student using(RN) where Name = 'Đàm Vĩnh Hưng';

        select RN from StudentSubject inner join Student using(RN) where Name = 'cao xuan quy';

        alter table StudentSubject add foreign key (RN) references Student(RN) on delete cascade;

        delete from Student where name = 'cao xuan quy';

        -- Hiển thị nội dung của view StudentInfo với danh sách sắp xếp theo tên(last Name)
        select * from StudentInfo_2 order by Name desc;

        -- Tạo một bảng tên là Top3 với các cột (Rank,RN, Name, Mark, sName, Date) với dữ liệu
                -- gồm chỉ 3 dòng có điểm cao nhất, cột Rank sẽ chứa số thứ tự từ 1 đến 3(dòng đầu tiên là
                -- 1, dòng thứ 2 là 2 và dòng thứ 3 là 3), còn cột Date sẽ nhận giá trị là ngày cập nhật thông
        -- tin.

                drop table if exists top3;
        create table top3 as
        select ss.RN, s2.Name, ss.Mark, s.sName, ss.Date from Subject as s inner join StudentSubject as ss using(SID) inner join Student as s2 using(RN);

        alter table top3 modify Date date default current_date();

        alter table top3 add column Rank int(11) not null auto_increment primary key first;

        drop table if exists top4;
        create table top4 as select * from top3 order by Mark desc limit 3;

        alter table top4 drop column Rank;

        alter table top4 add column Rank int(11) not null auto_increment primary key;

        -- Hiển thị danh sách toàn bộ các học sinh giỏi (Học sinh giỏi là những người có điểm trung
                -- bình lớn hơn 8.0 và không có điểm nào dưới 5).

        select s.RN, s.Name, avg(Mark) from Student as s  inner join StudentSubject as ss  using(RN) where ss.Mark >= 5 group by (s.RN)
                having avg(Mark) >= 8;

*/
    }
}
