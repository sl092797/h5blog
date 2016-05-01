<#assign menu="index">
<#include "/manage/head.ftl">
			
			<div class="main-container">
				<div class="padding-md">
					<div class="row">
						<div class="col-sm-6">
							<div class="page-title">
								欢迎, 系统管理员
							</div>
						</div>
					</div>

					<div class="row m-top-md">
						<div class="col-sm-6">
							<div class="statistic-box bg-danger m-bottom-md">
								<div class="statistic-title">
									今日来访
								</div>

								<div class="statistic-value">
									698
								</div>

								<div class="statistic-icon-background">
									<i class="ion-eye"></i>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="statistic-box bg-info m-bottom-md">
								<div class="statistic-title">
									总共来访
								</div>

								<div class="statistic-value">
									20.8k
								</div>

								<div class="statistic-icon-background">
									<i class="ion-ios7-cart-outline"></i>
								</div>
							</div>
						</div>
						
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="smart-widget widget-dark-blue">
								<div class="smart-widget-header">
									最近博客
									<span class="smart-widget-option">
										<span class="refresh-icon-animated">
											<i class="fa fa-circle-o-notch fa-spin"></i>
										</span>
			                            <a href="#" class="widget-toggle-hidden-option">
			                                <i class="fa fa-cog"></i>
			                            </a>
			                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
			                                <i class="fa fa-chevron-up"></i>
			                            </a>
			                            <a href="#" class="widget-refresh-option">
			                                <i class="fa fa-refresh"></i>
			                            </a>
			                            <a href="#" class="widget-remove-option">
			                                <i class="fa fa-times"></i>
			                            </a>
			                        </span>
								</div>
								<div class="smart-widget-inner">
									<div class="smart-widget-hidden-section">
										<ul class="widget-color-list clearfix">
											<li style="background-color:#20232b;" data-color="widget-dark"></li>
											<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
											<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
											<li style="background-color:#2baab1;" data-color="widget-green"></li>
											<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
											<li style="background-color:#fbc852;" data-color="widget-orange"></li>
											<li style="background-color:#e36159;" data-color="widget-red"></li>
											<li style="background-color:#7266ba;" data-color="widget-purple"></li>
											<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
											<li style="background-color:#fff;" data-color="reset"></li>
										</ul>
									</div>
									<div class="smart-widget-body no-padding">
										<div class="padding-md">
											<div id="totalSalesChart" class="morris-chart" style="height:250px;"></div>
										</div>
										
										<div class="bg-grey">
											<div class="row">
												<div class="col-xs-12 text-center">
													<h3 class="m-top-sm">999</h3>
													<small class="m-bottom-sm block">阅读量</small>
												</div>
											</div>
										</div>
									</div>
								</div><!-- ./smart-widget-inner -->
							</div><!-- ./smart-widget -->
						</div><!-- ./col -->
						<div class="col-lg-6">
							<div class="smart-widget widget-dark-blue">
								<div class="smart-widget-header">
									最近相册
									<span class="smart-widget-option">
										<span class="refresh-icon-animated">
											<i class="fa fa-circle-o-notch fa-spin"></i>
										</span>
			                            <a href="#" class="widget-toggle-hidden-option">
			                                <i class="fa fa-cog"></i>
			                            </a>
			                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
			                                <i class="fa fa-chevron-up"></i>
			                            </a>
			                            <a href="#" class="widget-refresh-option">
			                                <i class="fa fa-refresh"></i>
			                            </a>
			                            <a href="#" class="widget-remove-option">
			                                <i class="fa fa-times"></i>
			                            </a>
			                        </span>
								</div>
								<div class="smart-widget-inner">
									<div class="smart-widget-hidden-section">
										<ul class="widget-color-list clearfix">
											<li style="background-color:#20232b;" data-color="widget-dark"></li>
											<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
											<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
											<li style="background-color:#2baab1;" data-color="widget-green"></li>
											<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
											<li style="background-color:#fbc852;" data-color="widget-orange"></li>
											<li style="background-color:#e36159;" data-color="widget-red"></li>
											<li style="background-color:#7266ba;" data-color="widget-purple"></li>
											<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
											<li style="background-color:#fff;" data-color="reset"></li>
										</ul>
									</div>
									<div class="smart-widget-body no-padding">
										<div class="padding-md">
											<img src="${BASE_PATH}/images/gallery/gallery1.jpg">
										</div>

										<div class="bg-grey">
											<div class="row">
												<div class="col-xs-12 text-center">
													<h3 class="m-top-sm">999</h3>
													<small class="m-bottom-sm block">阅读量</small>
												</div>
											</div>
										</div>
									</div>
								</div><!-- ./smart-widget-inner -->
							</div><!-- ./smart-widget -->
						</div><!-- ./col -->
					</div>


				</div><!-- ./padding-md -->
			</div><!-- /main-container -->

			<footer class="footer">
				<span class="footer-brand">
					<strong class="text-danger">H5</strong> Blog
				</span>
				<p class="no-margin">
					&copy; 2016 <strong>Vic</strong>. ALL Rights Reserved. 
				</p>	
			</footer>
		</div><!-- /wrapper -->

		

		
		<#include "/manage/foot.ftl">
		
	
  	</body>
</html>
