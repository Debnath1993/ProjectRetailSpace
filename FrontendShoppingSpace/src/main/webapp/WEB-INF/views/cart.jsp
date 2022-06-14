<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<div class="container">

	<c:if test="${not empty message}">

		<div class="alert alert-info alert-dismissible " role="alert">
			${message}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>

	</c:if>
	<c:choose>
		<c:when test="${not empty cartLines}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartLine.product.code}.png"
											alt="${cartLine.product.name}" class="img-responsive" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartLine.product.name}</h4>
										<p>Brand : ${cartLine.product.brand}</p>
										<p>Description : ${cartLine.product.description}
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartLine.buyingPrice} /-</td>
							<td data-th="Quantity"><input type="number"
								id="count_${cartLine.id}" class="form-control text-center"
								value="${cartLine.productCount}" max="5" min="1"></td>
							<td data-th="Subtotal" class="text-center">&#8377;
								${cartLine.total} /-</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCart"
									class="btn btn-info btn-sm" value="${cartLine.id}">
									<i class="fa fa-refresh"></i>
								</button> <a href="${contextRoot}/cart/${cartLine.id}/remove"
								class="btn btn-danger btn-sm"> <i class="fa fa-trash-o"></i>
							</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377;
								${userModel.cart.grandTotal}/-</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/show/all/products"
							class="btn btn-warning"><i class="fa fa-angle-left"></i>
								Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>

						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${userModel.cart.grandTotal}/-</strong></td>


						<td><a href="${contextRoot}/cart/validate" class="btn btn-success btn-block">Checkout
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>

			<div class="jumbotron">

				<h3 class="text-center">Your Cart is Empty!</h3>

			</div>

		</c:otherwise>
	</c:choose>
</div>