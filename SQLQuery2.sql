CREATE DATABASE GShop
GO
 drop database GShop

------------- TẠO BẢNG -----------------------------------------------------------------------------------------------					

CREATE TABLE Grade(
	grade nvarchar(10) NOT NULL primary key,
	gradeName nvarchar(50) NULL,
	
	);
GO

CREATE TABLE Role(
	roleId int IDENTITY(1,1) NOT NULL primary key,
	roleName nvarchar(50) NULL,
	);
GO

CREATE TABLE Users(
	userId int IDENTITY(1,1) NOT NULL primary key,
	userName nvarchar(15) NOT NULL,
	pass nvarchar(16) NOT NULL,
	fullName nvarchar(max) NULL,
	wallet int NULL,
	dob date NULL,
	address nvarchar(max) NULL,
	phone nvarchar(10) NULL,
	creditCard char(17) NULL,
	createDate date NULL,
	roleId int NOT NULL CONSTRAINT FK_Users_Role FOREIGN KEY REFERENCES Role(roleId),
	avatar nvarchar(max) NULL
	);
GO

CREATE TABLE Store(
	storeId int NOT NULL primary key,
	storeName nvarchar(max) NOT NULL,
	userId int NOT NULL CONSTRAINT FK_Store_User FOREIGN KEY REFERENCES Users(userId),
	isActive bit NULL,
	wallet int NULL,
	bioStore nvarchar(max) NULL,
	createDate date NULL,
	);

CREATE TABLE Gunpla(
	gunplaId int IDENTITY(1,1) NOT NULL primary key,
	gunplaName nvarchar(max) NOT NULL,
	gradeId nvarchar(10) NOT NULL CONSTRAINT FK_Gunpla_Grade FOREIGN KEY REFERENCES Grade(grade),
	[desc] nvarchar(max) NULL,
	price int NULL,
	image nvarchar(max) NULL,
	stock int NULL,
	createDate date NULL,
	updateDate date NULL,
	storeId int NULL CONSTRAINT FK_Gunpla_Store FOREIGN KEY REFERENCES Store(storeId),
	ratingTotal int NULL,
	ratingNumber int NULL,
	);
GO


CREATE TABLE Status(
	statusId int IDENTITY(1,1) NOT NULL primary key ,
	statusDesc nvarchar(max) NULL,
	);
GO

CREATE TABLE [Order] (
	orderId int IDENTITY(1,1) NOT NULL primary key,
	userId int NOT NULL CONSTRAINT FK_Order_User FOREIGN KEY REFERENCES Users(userId) ,
	total int NULL,
	statusId int NULL CONSTRAINT FK_OrderDetail_Status FOREIGN KEY REFERENCES Status(statusId),
	createDate date NOT NULL,
	latestUpdate date NULL,
	);
GO

CREATE TABLE OrderDetail(
	orderDetailId int IDENTITY(1,1) NOT NULL primary key,
	orderId int NOT NULL CONSTRAINT FK_OrderDetail_Order FOREIGN KEY REFERENCES [Order](orderId),
	gunplaId int NOT NULL CONSTRAINT FK_OrderDetail_Gunpla FOREIGN KEY REFERENCES Gunpla(gunplaId),
	);
GO






-----INSERT TABLE---------------------------------------------------------------------------------------
INSERT INTO Grade (grade, gradeName)
VALUES 
	('GB' , N'Gấu Bông'),
	('BB', N'Búp bê'),
	('GL', N'Mô hình Gunpla');
GO


INSERT INTO Status( statusDesc)
VALUES
	  ( N'Chờ'),
	  ( N'Hoàn thành');
GO

INSERT INTO Role(roleName)
VALUES
	  ( 'admin'),
	  ( 'user'),
	  ( 'vendor');
GO

INSERT INTO Users(userName, pass, fullName, wallet,dob, [address], phone, createDate,  roleId)
VALUES
	  ( 'admin', '@admin123', N'Quản lí', '10000000', '1/1/2003', N'TP.HCM', '0112223344', '1/12/2023', '1'),
	  ( 'ThuyLinh', '@thuylinh123', N'Nguyễn Thị Thùy Linh', '10000000','1/1/2003', N'Tiền Giang', '0339347708','1/12/2023', '2'),
	  ( 'NgocTrang', '@ngoctrang123', N'Trần Thị Ngọc Trang', '10000000', '1/1/2003', N'Bình Phước', '0339339933','1/12/2023', '2'),
	  ( 'PhanQuoc', '@phanquoc123', N'Trần Phan Quốc', '10000000','1/1/2003', N'Đắk Lắk', '0339339934' ,'1/12/2023', '2');
GO



INSERT INTO Store(storeId,storeName, userId, isActive, wallet, bioStore)
VALUES
	  ( '1','TreEmShop', 2,'1', '10000000', N'Đồ chơi'),
	  ( '2','RickKidShop', 3, '1', '10000000', N'Đồ chơi');
GO


INSERT INTO Gunpla( gunplaName, gradeId, [desc], price, [image], stock, storeId)
VALUES
	  ( N'Gấu bông Lena', 'GB', N'Gấu Bông Lena, Thú Nhồi Bông Hình Gấu Lena Và Dâu Tây Dễ Thương', '180000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lkt71bhx67y8dd', '300', '1'), 
	  ( N'Gấu bông Heo Con', 'GB', N'Gấu Bông Heo Ôm Bình Sữa Lợn Bú Bình 30cm, Vải', '240000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lkuhtojy2e63aa', '300', '1'), 
	  ( N'Gấu bông Mèo Đen', 'GB', N'Thú Nhồi Bông Hình Chú Mèo Đen Đáng Yêu Trang Trí Phòng Ngủ', '300000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbmz-llorcf7nmnh567', '300', '1'), 
	  ( N'Gấu bông Trái Bơ', 'GB', N'Gấu bông trái bơ tròn nhỏ size 15cm cho bé xinh cute Gấu Xinh', '150000', 'https://down-vn.img.susercontent.com/file/f02fe1ffcf51cd8bb9b2d37a3cac7d31', '300', '1'), 
	  ( N'Gấu bông Gà Con', 'GB', N'MINISO Thú Nhồi Bông Hình Gà Vàng Dễ Thương 20CM', '325000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lf0kqv6o53eyd8', '300', '1'), 
	  ( N'Búp bê', 'BB', N'Búp bê bông búp bê điểm 20 cm dễ thương siêu mềm búp bê búp bê đồ chơi sang trọng', '280000', 'https://down-vn.img.susercontent.com/file/vn-11134201-7qukw-lj40j76gjjyqbd', '300', '1'), 
	  ( N'Búp bê dễ thương', 'BB', N'Búp bê bông kê bé khỏa thân tóc chiên dopamine ăn mặc quần áo búp bê dễ thương búp bê sang trọng quà tặng cho bạn bè', '130000', 'https://down-vn.img.susercontent.com/file/vn-11134201-7qukw-ljnrj10macacc9', '300', '1'), 
	  ( N'Búp bê BarBie', 'BB', N'Búp Bê Barbie 3D BJD Cao 30cm (có khớp linh hoạt)', '450000', 'https://down-vn.img.susercontent.com/file/ab365e1dfa01d8efbda13d8968d27d0f', '300', '1'), 
	  ( N'Búp bê Công Chúa', 'BB', N'Skjk Đồ Chơi Búp Bê Công Chúa Có Nhạc 3d Bằng Nhựa 30cm', '300000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbln-lli0npsdnaet5d', '300', '1'), 
	  ( N'Búp bê Barbie dạ hội', 'BB', N'Búp bê barbie 60cm có khớp có nhạc búp bê công chúa dạ hội xinh xắn quà sinh nhật cho bé gái E930', '500000', 'https://down-vn.img.susercontent.com/file/d23090c74b1eeb63360026dcca8317a5', '300', '1'), 
	  ( N'Gunpla HG', 'GL', N'Mô hình lắp ráp HG 1/144 AERIAL Fighter 03', '750000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lkw4eewlrzyj87', '300', '2'), 
	  ( N'Gunpla MG', 'GL', N'Mô hình gunpla mg 8814 astray red frame ver.mb', '350000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lop8ruxuk6iz0f', '300', '2'), 
	  ( N'Gunpla Metal Frame', 'GL', N'Mô hình lắp ráp Metal Frame MG 1/100 MNP-XH02 Caoren - Tào Nhân Cao Ren ( Motor Nuclear - Bản Thường )', '200000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lop8ruxuek97bf', '300', '2'), 
	  ( N'Gunpla HG Justice', 'GL', N'Mô hình HG Justice Gundam, 1/144 Gunpla, Xếp hình thông minh sưu tầm, Mô hình nhựa', '290000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lmzgqukypwbj9d', '300', '2'), 
	  ( N'Gunpla MG Gumdam EW Ver', 'GL', N'Mô hình MG Gundam Epyon EW Ver. 1/100 Gunpla, Mô hình nhựa, Đồ chơi sưu tầm thông minh', '650000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-ln051bm6xzqr01', '300', '2');
GO
	






