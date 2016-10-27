<!-- 
    
    Listing User Information
	
 -->

<template:basic htmlTitle="Users" bodyTitle="People">
	<!-- ============================================================== -->
	<div class="row">
		<div class="col-lg-12">
			<div class="portlet">
				<div class="portlet-heading bg-pink">
					<h3 class="portlet-title">Pink Heading</h3>
					<div class="portlet-widgets">
						<a href="javascript:;" data-toggle="reload"><i
							class="ion-refresh"></i></a> <span class="divider"></span> <a
							data-toggle="collapse" data-parent="#accordion1" href="#bg-pink"><i
							class="ion-minus-round"></i></a> <span class="divider"></span> <a
							href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="bg-pink" class="panel-collapse collapse in">
					<div class="portlet-body bg-pink">
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End row -->
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="table-responsive">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label>Show </label>
																<select>
																 	<option value="10">10</option>
																	<option value="25">25</option>
																	<option value="50">50</option>
																	<option value="100">100</option>
																</select>
															</div>	
														</div>
														
															<div class="col-md-4">
																														
															<div class="form-group">
																<label>Search:</label>
																<input type="text" placeholder="">																	
															</div>
															</div>
													</div>
													<table class="table">
														<thead>
															<tr>
																<th>#</th>
																<th>First Name</th>
																<th>Last Name</th>
																<th>Username</th>
																<th>Age</th>
																<th>City</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>1</td>
																<td>Mark</td>
																<td>Otto</td>
																<td>@mdo</td>
																<td>20</td>
																<td>Cityname</td>
															</tr>
															<tr>
																<td>2</td>
																<td>Jacob</td>
																<td>Thornton</td>
																<td>@fat</td>
																<td>20</td>
																<td>Cityname</td>
															</tr>
															<tr>
																<td>3</td>
																<td>Larry</td>
																<td>the Bird</td>
																<td>@twitter</td>
																<td>20</td>
																<td>Cityname</td>
															</tr>
															<tr>
																<td>4</td>
																<td>Steve</td>
																<td>Mac Queen</td>
																<td>@steve</td>
																<td>20</td>
																<td>Cityname</td>
															</tr>

														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End row -->

					</div>
				</div>
			</div>
		</div>
	</div>
</template:basic>
