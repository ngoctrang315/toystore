<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<div class="page-content-wrapper">

    <div class="page-content">

        <div class="row" style="margin: 10px;">

            <div class="col-md-12">

                <div class="portlet-title">

                    <div class="caption text-info">

                        <!-- row2 -->
                        <div class="row mt-4" style="padding-right: 25px">

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th style="color: #00DD00;">No</th>
                                        <th style="color: #00DD00;">Products</th>
                                        <th style="color: #00DD00;">Grade</th>
                                        <th style="color: #00DD00;">Price</th>
                                        <th>     </th>
                                        <th style="color: #00DD00;">Stock</th>
                                        <th>      </th> <!-- New column -->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listofcart}" var="cl" varStatus="STT">
                                        <tr class="odd gradeX" id="productRow${STT.index}">
                                            <td>${STT.index + 1}-${detaillist.size()}</td>
                                            <td>${cl[0]}</td>
                                            <td>${cl[1]}</td>
                                            <td>${cl[2]}</td>
                                            <td id="stock${STT.index}">${cl[4]}</td>
                                            <td>
                                                <form action="" method="post">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <button type="button" class="btn btn-sm btn-success" onclick="decreaseQuantity(${STT.index})">
                                                                <i class="fa fa-minus"></i>
                                                            </button>
                                                        </div>
                                                        <input type="text" style="width: 50px; text-align: center;" name="quantity" id="quantity${STT.index}" class="form-control" value="1" readonly>

                                                        <div class="input-group-append">
                                                            <button type="button" class="btn btn-sm btn-success" onclick="increaseQuantity(${STT.index})">
                                                                <i class="fa fa-plus"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </td>
                                            <td> </td>
                                            <td>                                       
                                                <button type="button" class="btn btn-sm btn-danger" onclick="removeFromCart(${STT.index})">
                                                    <i class="fa fa-trash"></i> Remove
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <div class="row">
                                <label class="form-label" style="width: 50px"></label>
                                <label class="form-label" style="height: 10px; color: #00DD00; font-weight: bold;" >Total Price</label>
                                <div class="col">
                                    <input type="text" name="totalprice" id="totalprice" readonly value="${order.total}">
                                </div>
                                <label class="form-label" style="width: 100px"></label>
                            </div>

                            <div class="row">
						    <div class="col">
						       <!-- Trong trang giỏ hàng -->
							<form method="post" action="<c:url value='/views/user/checkout.jsp'/>" id="checkoutForm">
							   <button class="btn btn-success" type="button" onclick="clearCart(); checkout();">
								    <i class="fa fa-shopping-cart" aria-hidden="true"></i> Purchase (<span id="cartItemCount">0</span>)
								</button>


							</form>

						    </div>
						</div>

                            </div>
                            <label class="form-label" style="width: 100px"></label>

                        </div>
                        <!-- end row2 -->
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

<script>




function increaseQuantity(index) {
    var currentQuantity = parseInt(document.getElementById('quantity' + index).value);

    if (currentQuantity >= 1) {
        document.getElementById('quantity' + index).value = currentQuantity +1;
        updateCartItemCount();
        updateTotalPrice();
    } else {
        removeFromCart(index);
    }
}

function decreaseQuantity(index) {
    var currentQuantity = parseInt(document.getElementById('quantity' + index).value);

    if (currentQuantity > 1) {
        document.getElementById('quantity' + index).value = currentQuantity - 1;
        updateCartItemCount();
        updateTotalPrice();
    } else {
        removeFromCart(index);
    }
}

function removeFromCart(index) {
    var productRow = document.getElementById('productRow' + index);
    productRow.parentNode.removeChild(productRow);

    // Cập nhật lại số thứ tự
    updateProductNumbers();

    updateCartItemCount();
    updateTotalPrice();
}

function updateProductNumbers() {
    // Cập nhật lại số thứ tự trong trường số thứ tự của mỗi sản phẩm
    var rows = document.querySelectorAll('tr.gradeX');
    rows.forEach(function (row, index) {
        row.querySelector('td:nth-child(1)').innerText = (index + 1) + '-' + detaillist.size();
    });
}


function updateCartItemCount() {
    var cartItemCount = 0;
    var quantityInputs = document.querySelectorAll('input[name="quantity"]');
    quantityInputs.forEach(function (input) {
        cartItemCount += parseInt(input.value);
    });
    document.getElementById('cartItemCount').innerText = cartItemCount;
}

function updateTotalPrice() {
    var totalPrice = 0;
    var rows = document.querySelectorAll('tr.gradeX');
    rows.forEach(function (row, index) {
        var quantity = parseInt(document.getElementById('quantity' + index).value);
        var price = parseFloat(document.querySelectorAll('td:nth-child(4)')[index].innerText);
        var newPrice = quantity * price;
        totalPrice += newPrice;
    });
    document.getElementById('totalprice').value = totalPrice.toFixed(2);
}



function clearCart() {
    // Lấy thẻ tbody của bảng giỏ hàng
    var cartTableBody = document.querySelector('table tbody');

    // Xóa tất cả các dòng trong tbody
    var rows = cartTableBody.getElementsByTagName('tr');
    while (rows.length > 0) {
        rows[0].parentNode.removeChild(rows[0]);
    }

    // Đặt lại mảng detaillist
    detaillist = [];

    // Cập nhật lại số thứ tự
    updateProductNumbers();

    // Cập nhật lại số lượng sản phẩm trong giỏ hàng và tổng giá
    updateCartItemCount();
    updateTotalPrice();
}






function checkout() {
    // Thực hiện xóa toàn bộ sản phẩm trong giỏ hàng
    clearCart();

    // Chuyển hướng đến trang thanh toán
    window.location.replace('<c:url value="/views/user/checkout.jsp"/>');
}









</script>