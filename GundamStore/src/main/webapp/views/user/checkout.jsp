<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
<div class="container mt-4">
    <form class="needs-validation" name="frmthanhtoan" method="post" action="<c:url value='/checkout'/>" onsubmit="return submitOrder()">
        <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3" style="color: #0000BB;">Customer's information</h4>

                <div class="row">
                    <div class="col-md-6">
                        <label for="kh_ten">Name</label>
                        <input type="text" class="form-control" name="kh_ten" required>
                        <div class="invalid-feedback">
                            Please enter your name.
                        </div>
                    </div>

                    <div class="col-md-6">
                        <label for="kh_diachi">Phone</label>
                        <input type="text" class="form-control" name="kh_diachi" required>
                        <div class="invalid-feedback">
                            Please enter your phone number.
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="kh_dienthoai">Address</label>
                        <input type="text" class="form-control" name="kh_dienthoai" required>
                        <div class="invalid-feedback">
                            Please enter your address.
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="kh_email">Email</label>
                        <input type="text" class="form-control" name="kh_email" required>
                        <div class="invalid-feedback">
                            Please enter your email address.
                        </div>
                    </div>
                </div>
                <hr class="mb-6">
                <button class="btn btn-primary btn-lg btn-block" type="submit" name="btnDatHang" onclick="checkBalance()">Order</button>

                <div style="margin-top: 40px;"></div>
            </div>

            <!-- Phương thức thanh toán bên phải -->
            <div class="col-md-90" style="margin-right: 30px;">
                <h4 class="mb-3" style="color: #0000BB;">Payment Method</h4>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="paymentCOD" name="paymentMethod" value="COD" onclick="togglePaymentFields('codFields')">
                    <label class="form-check-label" for="paymentCOD">Cash on Delivery</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="paymentOnline" name="paymentMethod" value="Online" onclick="togglePaymentFields('onlineFields')">
                    <label class="form-check-label" for="paymentOnline">Online Payment</label>
                </div>
                <div class="invalid-feedback" id="paymentError">
                    Please select a payment method.
                </div>

                <!-- Fields for Cash on Delivery -->
                <div id="codFields">
                    <!-- Include fields specific to Cash on Delivery if needed -->
                </div>

                <!-- Fields for Online Payment 
                <div id="onlineFields" style="display: none;">
                    <div class="form-group">
                        <label for="bank">Bank</label>
                        <select class="form-control" id="bank" name="bank">
                            <option value="sacombank">Sacombank</option>
                            <option value="viettinbank">Viettinbank</option>
                            <option value="acb">AC Bank</option>
                            <option value="bidv">BIDV</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNumber" name="cardNumber">
                    </div>
                    
                    <input type="hidden" name="balance" id="balance" value="${user.wallet}">

                    
                </div>
            </div>  -->
        </form>
    </div>
</div>

<script>


function checkBalance() {
    // Lấy giá trị số dư và tổng tiền cần thanh toán
    var balance = parseFloat(document.getElementById('balance').value);
    var amount = parseFloat(document.getElementById('amount').value);

    // Kiểm tra xem số dư có đủ hay không
    if (balance >= amount) {
        // Nếu đủ, thực hiện thanh toán
        alert('Thanh toán thành công');

        // Cập nhật số dư mới
        var newBalance = balance - amount;
        document.getElementById('balance').value = newBalance;

        // Gửi dữ liệu form đi
        document.getElementById('frmthanhtoan').submit();
    } else {
        // Nếu không đủ, hiển thị thông báo
        alert('Số dư không đủ. Vui lòng chọn phương thức thanh toán khác.');
    }
}





    function togglePaymentFields(paymentType) {
        var codFields = document.getElementById('codFields');
        var onlineFields = document.getElementById('onlineFields');
        var paymentError = document.getElementById('paymentError');

        if (paymentType === 'codFields') {
            codFields.style.display = 'block';
            onlineFields.style.display = 'none';
            paymentError.style.display = 'none';
        } else if (paymentType === 'onlineFields') {
            codFields.style.display = 'none';
            onlineFields.style.display = 'block';
            paymentError.style.display = 'none';
        }
    }

    function submitOrder() {
        // Kiểm tra xem tất cả các trường thông tin đã được điền đầy đủ chưa
        var name = document.forms['frmthanhtoan']['kh_ten'].value;
        var phone = document.forms['frmthanhtoan']['kh_diachi'].value;
        var address = document.forms['frmthanhtoan']['kh_dienthoai'].value;
        var email = document.forms['frmthanhtoan']['kh_email'].value;
        var paymentMethod = document.forms['frmthanhtoan']['paymentMethod'].value;

        if (name === '' || phone === '' || address === '' || email === '') {
            alert('Vui lòng điền đầy đủ thông tin khách hàng.');
            return false;
        }

        // Kiểm tra số dư tài khoản có đủ để thanh toán hay không
        // Trong Servlet hoặc Controller

        if (paymentMethod !== 'COD' && paymentMethod !== 'Online') {
            var paymentError = document.getElementById('paymentError');
            paymentError.style.display = 'block';
            return false;
        }

        

        // Xử lý logic thanh toán ở đây (gửi dữ liệu đến server nếu cần)

        // Hiển thị chatbox "thanh toán thành công"
        alert('Thanh toán thành công');
        
       // resetCart();

        // Quay về trang home
        window.location.replace('/GundamStore/home');

        //Trả về false để ngăn form gửi đi và trang được chuyển hướng bởi JavaScript
        return false;
    }

   

</script>
<!-- End block content -->