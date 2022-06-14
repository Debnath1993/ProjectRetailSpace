<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<div class="container">

	<div class="row">


		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>


		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">

							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>

			<div class="col-sm-12">


				<table id="productTable"
					class="table table-condensed table-striped table-hover">

					<thead>
						<tr>
							<th></th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>UNIT PRICE</th>
							<th>AVAILABLE QUANTITY</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th></th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>UNIT PRICE</th>
							<th>AVAILABLE QUANTITY</th>
							<th></th>

						</tr>
					</tfoot>

				</table>
			</div>


		</div>

	</div>



</div>