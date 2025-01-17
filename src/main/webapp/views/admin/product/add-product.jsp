<%@ include file="/views/includes/header.jsp"%>
<div class="container mt-5 mb-5 d-flex justify-content-center">
	<div class="card" style="width: 50rem;">
		<c:if test="${not empty requestScope.product.image}">
			<img src="${requestScope.product.image}"
				class="card-img-top mx-auto w-25" style="border-radius: 50%;">
		</c:if>
		<div class="card-header text-center text-bg-success mb-5">Add
			Product</div>
		<div class="card-body">
			<form action="addProduct" method="post" enctype="multipart/form-data">
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Brand:</b></label>
					</div>
					<div class="col">
						<select class="form-select" name="brand" required>
							<c:forEach var="brand" items="${listBrand}">
								<option value="${brand.id }">${brand.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Name:</b></label>
					</div>
					<div class="col">
						<input type="text" name="name" class="form-control" required>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Image:</b></label>
					</div>
					<div class="col">
						<input class="form-control" type="file" name="image">
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Price ($):</b></label>
					</div>
					<div class="col">
						<input type="text" name="price" class="form-control"
							pattern="^\d+(\.\d{1,2})?$" title="Enter a valid price in USD"
							required>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Storage (GB):</b></label>
					</div>
					<div class="col">
						<input type="text" name="storage" class="form-control"
							pattern="\d+(\.\d+)?" title="Enter a valid number" required>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>RAM (GB):</b></label>
					</div>
					<div class="col">
						<input type="text" name="ram" class="form-control"
							pattern="\d+(\.\d+)?" title="Enter a valid number" required>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>OS:</b></label>
					</div>
					<div class="col">
						<input class="form-control" list="listOS" name="os"
							placeholder="Type to search..." required>
						<datalist id="listOS">
							<option value="Android">
							<option value="iOS">
							<option value="Windows Phone">
							<option value="KaiOS">
							<option value="Ubuntu Touch">
							<option value="Sailfish OS">
							<option value="Tizen">
							<option value="BlackBerry OS">
						</datalist>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Quantity:</b></label>
					</div>
					<div class="col">
						<input type="text" name="quantity" class="form-control"
							pattern="[0-9]+" title="Enter a valid number" required>
					</div>
				</div>
				<div class="row align-items-center mb-3">
					<div class="col-3">
						<label class="form-label"><b>Description:</b></label>
					</div>
					<div class="col">
						<textarea name="description" cols=93 rows="5"
							title="Please enter text" required></textarea>
					</div>
				</div>
				<div class="text-center mb-3">
					<button type="submit" class="btn btn-primary">Add</button>
				</div>

			</form>
		</div>
	</div>
</div>
<%@ include file="/views/includes/footer.jsp"%>