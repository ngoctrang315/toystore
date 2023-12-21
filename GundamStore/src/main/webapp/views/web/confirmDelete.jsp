<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Xác nhận xóa</title>
    <!-- Thêm mã JavaScript -->
    <script>
        function confirmDelete() {
            var confirmed = confirm("Bạn có chắc chắn muốn xóa không?");
            if (confirmed) {
                // Nếu xác nhận xóa, chuyển hướng đến servlet để thực hiện xóa
                window.location.href = "<c:url value='/your-servlet-url-for-delete'/>?id=${gunplaIdToDelete}";
            } else {
                // Nếu không xác nhận, quay lại trang trước đó hoặc thực hiện hành động khác
                // Ví dụ: history.back() để quay lại trang trước đó
                history.back();
            }
        }
    </script>
</head>
<body>
    <!-- Gọi hàm xác nhận xóa khi trang được tải -->
    <script>
        confirmDelete();
    </script>
</body>
</html>
