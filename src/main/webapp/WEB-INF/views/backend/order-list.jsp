<!DOCTYPE html>
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<jsp:include page="/WEB-INF/views/backend/layout/header.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/views/backend/layout/header1.jsp"></jsp:include>
<!-- partial -->
<div class="container-fluid page-body-wrapper">
	<jsp:include page="/WEB-INF/views/backend/layout/sidebar.jsp"></jsp:include>
	<div class="main-panel">
          <div class="content-wrapper">
           
<div class="table-responsive">
                                	
                               <div class="row">
                    <div class="col-12">
                        <div class="card">
                        	
                            <div class="card-body">
	                        	<form action="${classpath }/admin/product/list" method="get">
		                            <div class="table-responsive">
	                                	
	                               	<div class="row">
										<div class="col-md-2">
											<div class="form-group mb-4">
												<a href="${classpath }/admin/product/add" role="button"
													class="btn btn-primary">Add new product</a>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group mb-4">
												<h3>Total products: &nbsp ${productSearch.totalItems }</h3>
											</div>
										</div>	
										
										<div class="col-md-6">
											<div class="form-group mb-4">
												<label>Current page</label>
												<input id="currentPage" name="currentPage" class="form-control"
														value="${productSearch.currentPage }">
											</div>
										</div>	
	
									</div>	
										<!-- Tìm kiếm -->
										<div class="row">
											<div class="col-md-2">
												<div class="form-group mb-4">
													<!-- 
													<label for="status">&nbsp;&nbsp;&nbsp;&nbsp;</label>
													<input type="checkbox" class="form-check-input" id="status" name="status" checked="checked" />
			                                        <label for="status">Active</label>
			                                         -->
			                                        <select class="form-control"
														id="status" name="status">
															<option value="2">All</option>
															<option value="1">Active</option>
															<option value="0">Inactive</option>
													</select>
												</div>
											</div>
											
											<div class="col-md-2">
												<select class="form-control" id="categoryId" name="categoryId" style="margin-right: 10px;">
													<option value="0">Select category</option>
													<c:forEach items="${categories }" var="category">
														<option value="${category.id }">${category.name }</option>
													</c:forEach>
												</select>
											</div>
											
											<div class="col-md-2">
												<input class="form-control" type="date" 
													id="beginDate" name="beginDate"/>		
											</div>
											<div class="col-md-2">
												<input class="form-control"
																type="date" id="endDate" name="endDate" />		
											</div>
											
											<div class="col-md-3">
												<input type="text" class="form-control" id="keyword"
														name="keyword" placeholder="Search keyword" />		
											</div>
											
											<div class="col-md-1">
												<button type="submit" id="btnSearch" name="btnSearch" class="btn btn-primary">Search</button>
											</div>
										</div>
										<!-- Hết tìm kiếm -->
	                                    <table id="zero_config" class="table table-striped table-bordered no-wrap">
	                                       <thead>
													<tr align="center">
														<th scope="col">No.</th>
														<th scope="col">Code</th>
														<th scope="col">Customer</th>
														<th scope="col">Mobile</th>
														<th scope="col">Address</th>
														<th scope="col">Payment</th>
														<th scope="col">Create by</th>
														<!-- <th scope="col">Update by</th> -->
														<th scope="col">Create date</th>
														<th scope="col">Delivery date</th>
														<th scope="col">Status</th>
														<th scope="col">Edit</th>
														<th scope="col">Delete</th>
	
													</tr>
												</thead>
	                                        <tbody>
	                                        	<c:forEach var="saleOrder" items="${saleOrders }"
														varStatus="loop">
														<tr>
															<th scope="row">${loop.index + 1 }</th>
	
															<td align="center">${saleOrder.code }</td>
															<td>${saleOrder.customerName }</td>
															<td align="center">${saleOrder.customerMobile }</td>
															<td>${saleOrder.customerAddress }</td>
															<td align="right"><fmt:formatNumber
																	value="${saleOrder.total }" minFractionDigits="0"></fmt:formatNumber>
															</td>
															<td>${saleOrder.userCreateSaleOrder.username }</td>
															<%-- <td>${saleOrder.updateBy }</td> --%>
															<td><fmt:formatDate pattern="dd-MM-yyyy"
																	value="${saleOrder.createDate}" /></td>
															<td><fmt:formatDate pattern="dd-MM-yyyy"
																	value="${saleOrder.updateDate}" /></td>
	
															<td><c:choose>
																	<c:when test="${saleOrder.status }">
																		Shipped
																	</c:when>
																	<c:otherwise>Haven't ship</c:otherwise>
																</c:choose></td>
	
															<td><a
																href="${rootpath }/edit-product/${saleOrder.id }"
																role="button" class="btn btn-primary">Edit</a>
															<td><a
																href="${rootpath }/delete-product/${saleOrder.id }"
																role="button" class="btn btn-secondary">Delete</a>
														</tr>
													</c:forEach>
	                                        </tbody>
	                                        
	                                    </table>
	                                    
	                                    <div class="row">
												<div class="col-md-6">
													<div class="form-group mb-4">
														<h3>
															Total sales:
															<fmt:formatNumber value="${totalSales }"
																minFractionDigits="0"></fmt:formatNumber>($)
														</h3>
													</div>
												</div>
	
												<div class="col-md-6" >
													<!-- Phan trang -->
													<div class="pagination float-right">
														<div id="paging"></div>
													</div>
												</div>
											</div>
		                            </div>	                           
	                        	</form>
                            </div>
                        </div>
                    </div>
                </div>
	          </div>
          <!-- content-wrapper ends -->
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>

<!-- content-wrapper ends -->
<!-- main-panel ends -->

<!-- container-scroller -->
<jsp:include page="/WEB-INF/views/backend/layout/js.jsp"></jsp:include>
</body>
</html>