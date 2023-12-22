---CREATE DATABASE ToyShop
---GO


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
	('DCXD', N'Đồ Chơi Xây Dựng'),
	('DCGD', N'Đồ Chơi Giáo Dục'),
	('BBDCGM', N'Búp Bê và Đồ Chơi Giả Mạo'),
	('DCTT', N'Đồ Chơi Thể Thao'),
	('DCNC', N'Đồ Chơi Nhạc Cụ'),
	('DCLRP', N'Đồ Chơi Lắp Ráp và Puzzle'),
	('DCDKTX', N'Đồ Chơi Điều Khiển Từ Xa'),
	('DCNO', N'Đồ Chơi Ngoại Ô'),
	('DCCN', N'Đồ Chơi Công Nghệ'),
	('DCVD', N'Đồ Chơi Vận Động');
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
	  ( 'Admin', 'Admin123', N'Quản lí', '9450000', '1/1/2003', N'TP.HCM', '0112223344', '1/12/2023', '1'),
	  ( 'ThuyLinh', 'ThuyLinh123', N'Nguyễn Thị Thùy Linh', '9000000','1/1/2003', N'Tiền Giang', '0339347708','1/12/2023', '2'),
	  ( 'NgocTrang', 'NgocTrang123', N'Trần Thị Ngọc Trang', '3000000', '1/1/2003', N'Bình Phước', '0339339933','1/12/2023', '2'),
	  ( 'PhanQuoc', 'PhanQuoc123', N'Trần Phan Quốc', '3000000','1/1/2003', N'Đắk Lắk', '0339339934' ,'1/12/2023', '2');
GO



INSERT INTO Store(storeId,storeName, userId, isActive, wallet, bioStore)
VALUES
	  ( '1','TreEmShop', 2,'1', '10000000', N'Đồ chơi cho trẻ '),
	  ( '2','RickKidShop', 3, '1', '10000000', N'Đồ chơi ');
GO


INSERT INTO Gunpla( gunplaName, gradeId, [desc], price, [image], stock, storeId)
VALUES

  (N'Xe Cẩu Xây Dựng', 'DCXD', N'Xe cẩu chòi chân có cần múc', '100000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lfgis3n5i645f1', '100', '1'),
  (N'Nhà Gạch Lego', 'DCXD', N'Gạch LEGO Sakura Ngôi Nhà Trên Cây Bé Gái Series Vườn Lâu Đài Hạt Nhỏ Lắp Ráp Đồ Chơi', '300000', 'https://down-vn.img.susercontent.com/file/vn-11134201-7r98o-lmbzizvyml0ff6', '100', '1'),
  (N'Bộ Đồ Chơi Xây Dựng Mô Hình', 'DCXD', N'Bộ đồ chơi lắp ráp khối xây dựng mô hình máy bay dân dụng', '400000', 'https://down-vn.img.susercontent.com/file/sg-11134201-22120-nioqs580q4kv24', '100', '1'),
  (N'Xe Tải Xây Dựng', 'DCXD', N'Xe Tải Ben Đa Khớp Di Động Điều Khiển Từ Xa Xây Dựng Đồ Chơi Với Ánh Sáng Đầy Đủ Màu Sắc', '100000', 'https://down-vn.img.susercontent.com/file/cn-11134207-7r98o-lob7czwkyqzn84', '100', '1'),
  (N'Hộp Đồ Chơi Lắp Ghép Xây Dựng', 'DCXD', N'Bộ Đồ Chơi Lắp Ghép Xếp Hình Khối Nhựa Xây Dựng Building Block Phát Triển Tư Duy Thông Minh Cho Bé', '200000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lfo34ememsmt42', '100', '1'),
  (N'Bảng Chữ Cái Nhiều Màu', 'DCGD', N'Bảng gỗ chữ cái tiếng việt chữ in hoa, chữ thường nhiều màu cho trẻ em, đồ chơi gỗ giáo dục thông minh', '100000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljjinu0tl9tuf6', '100', '1'),
  (N'Bộ Xây Dựng Số Học', 'DCGD', N'Bảng Chữ Số Từ 1 - 20 Bẳng Gỗ An Toàn Cho Bé Nhận Biết Và Học Đếm Chữ Số', '100000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-ljcgx0xmw0cyd9', '100', '1'),
  (N'Dụng Cụ Hỗ Trợ Học Tiếng Anh', 'DCGD', N'Bút biết nói thông minh Alilo D3C Early Educational Talking Pen - Đồ chơi giáo dục sớm hỗ trợ bé 2-6T học tiếng anh', '100000', 'https://down-vn.img.susercontent.com/file/sg-11134201-22120-7zocl8em02kv7a', '100', '1'),
  (N'Bảng Dạy Số và Đếm', 'DCGD', N'Đồ Chơi Bảng Cửu Chương, Bảng Gỗ Học Số Cho Bé Phát Triển Trí Não', '100000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-llcxl7gwp7sm4c', '100', '1'),
  (N'Bảng Học Các Loại Động Vật', 'DCGD', N'Bảng ghép hình núm gỗ nhiều chủ đề cho bé các loài động vật', '100000', 'https://down-vn.img.susercontent.com/file/bc75ff783869316f9007eb0476a793e0', '100', '1'),
  (N'Búp Bê Barbie', 'BBDCGM', N'Búp Bê Barbie Mặc Đồ Cưới Dễ Thương Cho Bé', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7qvdq-lj3s3woag9vxb5', '100', '1'),
  (N'Bộ Đồ Chơi Bác Sĩ', 'BBDCGM', N'Bộ Đồ Chơi Bác Sĩ Vui Nhộn Cho Bé', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7qvfj-lj2imbzwlg5i8f', '100', '1'),
  (N'Búp Bê Siêu Anh Hùng', 'BBDCGM', N'Búp Bê Đồ Chơi Hình Nhân Vật Siêu Anh Hùng marvel', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rblg-lm4h9opqnpztc0', '100', '1'),
  (N'Búp Bê Gái Mô Phỏng', 'BBDCGM', N'Búp Bê Công Chúa Nhỏ Dễ Thương 12 Inch Dễ Thương Loli Béo Bé Gái Trẻ Em Đồ Chơi Sinh Nhật Quà Tặng Mô Phỏng Búp Bê', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbm5-lo27fdxfb1o1f3', '100', '1'),
  (N'Bộ Đồ Chơi Đầu Bếp', 'BBDCGM', N'Bộ đồ chơi kabeiqi nấu ăn bằng gỗ cao cấp cho bé toystore FUDAER', '200000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-llfvozytkslk95', '100', '2'),
  (N'Bóng Đá Mini', 'DCTT', N'Oyang Bộ Trò Chơi Bóng Đá pinball mini Để Bàn Trang Trí Phòng Khách Trong Nhà', '150000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbn3-lmzzqgr7gldh13', '100', '2'),
  (N'Vợt Cầu Lông', 'DCTT', N'Enlee Vợt Cầu Lông Đơn Bằng Sợi carbon Siêu Nhẹ Và Bền', '150000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7qveb-lhx37mm4zhwt4e', '100', '2'),
  (N'Xe Đạp Mini', 'DCTT', N'Xe đạp thể thao gấp gọn mini GoodFit tùy chỉnh độ nặng, tập luyện thể dục tại nhà', '500000', 'https://down-vn.img.susercontent.com/file/b8818517c6d1834fee982ceea3859839', '100', '2'),
  (N'Bóng Rổ Nhỏ', 'DCTT', N'Beibeiyin Đồ Chơi Khung Bóng Rổ Hoạt Hình Có Giác Hút Gắn Phòng Tắm Cho Bé', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7qve5-lj15gsm0tq0nbf', '100', '2'),
  (N'Kèn Thổi Bóng', 'DCTT', N'Đồ chơi thể thao cho bé BBT Global', '150000', 'https://down-vn.img.susercontent.com/file/2deeb93ed25d9e9b5e495ce2df75c5ac', '100', '2'),
  (N'Đàn Piano Mini', 'DCNC', N'Đàn Piano Mini Cho Bé Casio SA-80 - Việt Thương Music', '600000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7qukw-lg4ytua9w1yve7', '100', '1'),
  (N'Kèn Trumpet Nhỏ', 'DCNC', N'Kèn trumpet b-b flat trumpet Với Miệng Thổi Cho Học Sinh Trẻ Nhỏ', '200000', 'https://down-vn.img.susercontent.com/file/sg-11134201-7rbnd-ln9xamdr3z75cf', '100', '1'),
  (N'Trống Đồ Chơi', 'DCNC', N'Đồ Chơi Gỗ S-Kids, Bộ Trống Gỗ Mặt Simili Cho Bé.', '50000', 'https://down-vn.img.susercontent.com/file/c203fa4cae056cc0901aef32f04eaa9c', '100', '1'),
  (N'Micro Karaoke', 'DCNC', N'Micro Đồ Chơi karaoke Khuếch Đại Âm Thanh Vui Nhộn Cho Bé', '100000', 'https://down-vn.img.susercontent.com/file/83dd2d1c1b73ee44c28399f6010805a7', '100', '1'),
  (N'Đàn Guitar Điện Tử', 'DCNC', N'Đồ chơi đàn ghi ta điện tử có nhạc cho bé Pikaboo phím đàn và nút âm thanh sống động phong cách rock girl', '750000', 'https://down-vn.img.susercontent.com/file/bc58bb57f9e5e533d10c7009fcecf610', '100', '1'),
  (N'Bộ Lắp Ráp Gunpla', 'DCLRP', N'LEGO Ninjago 71782 Rồng Thần Tiến Hóa Của Cole (285 Chi Tiết)', '600000', 'https://down-vn.img.susercontent.com/file/vn-11134201-7r98o-lo1iz9wb1srx92', '200', '1'),
  (N'Puzzle 100 Chiếc', 'DCLRP', N'Tranh Ghép Hình Mini Puzzle Cho Bé 2D 15 Chi Tiết (12cm 8cm)', '500000', 'https://down-vn.img.susercontent.com/file/sg-11134201-22110-ar52hxn81ejv9d', '200', '1'),
  (N'Mô Hình Tàu Lượn Siêu Tốc', 'DCLRP', N'Mô Hình Đồ Chơi Hot Wheels Bộ Tàu Lượn Siêu Tốc HDP04', '600000', 'https://down-vn.img.susercontent.com/file/05ff0af3a13d08e172110ce7608ac3a7', '200', '1'),
  (N'Mô Hình Nhân Vật Hoạt Hình', 'DCLRP', N'Mô Hình Đồ Chơi Nhân Vật Hoạt Hình Doraemon Thu Nhỏ', '200000', 'https://down-vn.img.susercontent.com/file/6db0106bbe0754c3438b9a97639a28cd', '200', '1'),
  (N'Bộ Lắp Ráp Xe Đua', 'DCLRP', N'Bộ Đồ Chơi Lắp Ráp Đường Ray Xe Lửa Chạy Bằng Điện Tự Động DIY Cho Bé Tàu lửa chạy trên đường đua sáng tạo', '700000', 'https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lmisu7aodg4f89', '200', '1'),
  (N'Xe Điều Khiển Từ Xa', 'DCDKTX', N'Xe điều khiển kiểu dáng thể thao 020', '300000', 'https://daiphattoy.vn/upload/sanpham/large/xe-dieu-khien-kieu-dang-the-thao-020-1619080583-ffc03e.jpg', '200', '1'),
  (N'Máy Bay Điều Khiển Từ Xa', 'DCDKTX', N'Trực thăng điều khiển từ xa WOLF FORCE (xanh dương)', '500000', 'https://u6wdnj9wggobj.vcdn.cloud/media/catalog/product/cache/a237138a07ed0dd2cc8a6fa440635ea6/v/t/vtf8_2_.jpg', '200', '2'),
  (N'Xe Cảnh Sát Điều Khiển Từ Xa', 'DCDKTX', N'Đồ chơi xe cảnh sát điều khiển từ xa 013', '200000', 'https://daiphattoy.vn/upload/sanpham/large/do-choi-xe-canh-sat-dieu-khien-tu-xa-013-1616834506-9028fa.jpg', '200', '2'),
  (N'Robot Điều Khiển Từ Xa', 'DCDKTX', N'Đồ chơi Robot điều khiển từ xa Bruno (xanh)', '400000', 'https://u6wdnj9wggobj.vcdn.cloud/media/catalog/product/cache/a237138a07ed0dd2cc8a6fa440635ea6/v/t/vt99333-2bl.jpg', '200', '2'),
  (N'Xe Đạp Điện Trẻ Em', 'DCNO', N'Xe máy điện trẻ em', '1200000', 'https://smartbaby.com.vn/wp-content/uploads/2022/10/xe-may-dien-tre-em-chu-cho-puppy-bbt-689-11.jpg', '200', '2'),
  (N'Kính Thiên Văn', 'DCNO', N'Kính thiên văn trẻ em JOYCARE F36050', '700000', 'https://joycare.vn/wp-content/uploads/2023/05/z4377940469883_f032d8c771deffeb992b5ea2fbaa35cb-600x600.jpg', '200', '2'),
  (N'Đồ Chơi Cắm Trại', 'DCNO', N'ĐỒ CHƠI CẮM TRẠI TUMAMA CHO BÉ', '600000', 'https://product.hstatic.net/1000186075/product/cam_trai_4b5ab3aff56745ac8e2fff1bae7706bd_master.png', '200', '2'),
  (N'Máy Tính Bảng Trẻ Em', 'DCCN', N'Máy Tính Bảng Android 10.0 Rẻ Nhất, Máy Tính Bảng 4 Nhân 10 Inch Nghiêng Hai Sim Cho Trẻ Em', '500000', 'https://s.alicdn.com/@sc04/kf/H33721a376cb54497becdd2fc3827c3f9b.jpg_300x300.jpg', '200', '2'),
  (N'Đồng Hồ Thông Minh', 'DCCN', N'Đồng hồ thông minh định vị trẻ em y31 mẫu mới năm 2022', '400000', 'https://product.hstatic.net/200000289371/product/5f6a41d137795ce5858007fcd0a0fc51_0997b055560c42d1875bbbef2cf5e818_large.jpg', '200', '2'),
  (N'Robot Lập Trình', 'DCCN', N'Robot lập trình Ultimate Robot Kit V2.0', '3000000', 'https://s.meta.com.vn/Data/image/2022/04/13/robot-lap-trinh-ultimate-robot-kit-v2-0-1.jpg', '200', '2'),
  (N'Máy Ảnh Kỹ Thuật Số Trẻ Em', 'DCCN', N'Máy Ảnh Mini Kỹ Thuật Số Sạc Được Màn Hình HD 2 Inch Chụp Ảnh Ngoài Trời Máy Ảnh Hoạt Hình Dễ Thương Cho Trẻ Em', '1200000', 'https://s.alicdn.com/@sc04/kf/H1160ceac55454c938f9bda1ab408d7fcs.jpg_300x300.jpg', '200', '2'),
  (N'Thảm Nhảy', 'DCVD', N'Bàn nhún lò xo cho bé luyện bật nhảy PL1901-122', '500000', 'https://dochoiphulong.com/wp-content/uploads/2020/10/ban-nhun-chinh-hang-vnjump.jpg', '200', '2'),
  (N'Bóng Nhảy', 'DCVD', N'Bóng Nhảy Vòng Tròn', '100000', 'https://salt.tikicdn.com/cache/w400/ts/product/f6/56/40/f8eaaf911602e51765a33aa3d7e8148d.jpg', '200', '2'),
  (N'Xe Trượt', 'DCVD', N'Xe trượt scooter, xe chòi chân có nhạc đèn 166', '400000', 'https://cdn1.concung.com/2022/03/56296-85423-large_mobile/xe-truot-scooter-xe-choi-chan-co-nhac-den-166-hong.jpg', '200', '2'),
  (N'Bóng Yoga', 'DCVD', N'Thân Thiện Với Môi PVC Pilates Tập Thể Dục Trong Nhà Phòng Tập Thể Dục Yoga Tập Thể Dục Bóng', '70000', 'https://s.alicdn.com/@sc04/kf/Haab38a67631d47648af8c5224e8516865.jpg_110x110.jpg', '200', '2'),
  (N'Găng Tay Đua Xe Đạp', 'DCVD', N'Bao tay Wheystore', '180000', 'https://www.wheystore.vn/upload/product_optimize/image/upl_bao_tay_wheystore_1699254619_image_1699254619.jpg', '200', '2'),	 
  (N'Bộ Lắp Ráp Gunpla', 'DCLRP', N'LEGO Ninjago 71782 Rồng Thần Tiến Hóa Của Cole (285 Chi Tiết)', '600000', 'https://down-vn.img.susercontent.com/file/vn-11134201-7r98o-lo1iz9wb1srx92', '200', '2');
GO
	






