<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 学习计划 -->
<div id="stydyplanid">
<div class="col-md-6 column" style="-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);border:#EDEFF0 solid;border-width:5px; background-color: #FFFFFF;">
	<h4 style="margin-top:10px;">
		学习计划
	</h4>
	<hr style="margin-top: 10px; height:1px;border:none;border-top:2px dotted ;">
	<div class="col-md-12 column" style="overflow-x:hidden; height:498px;">
		 <!-- 计划时间开始 -->
		  <form class="form-inline" role="form">
			  <div class="form-group">
			  	<label  for="name">按计划时间查询：</label>
			    <input type="text" onchange="openmyplaninfosindex();" class="form-control input-sm" id="time1" placeholder="****-**-**">
			    ~
			    <input type="text" onchange="openmyplaninfosindex();" class="form-control input-sm" id="time2" placeholder="****-**-**">
			    <script type="text/javascript">
				    var picker = new Pikaday(
				    {
				        field: document.getElementById('time1'),
				        firstDay: 1,
				        minDate: new Date('2010-01-01'),
				        maxDate: new Date('2020-12-31'),
				        yearRange: [2000,2020]
				    });
				    var picker = new Pikaday(
				    {
				        field: document.getElementById('time2'),
				        firstDay: 1,
				        minDate: new Date('2010-01-01'),
				        maxDate: new Date('2020-12-31'),
				        yearRange: [2000,2020]
				    });
				    
				</script>
			  </div>
			  
			</form>
			<!-- 计划时间结束 -->
			
			<table class="table table-hover" style="font-size: 13px;">
				<thead>
					<tr>
						<th>计划标题</th>
						<th>计划时间</th>
						<th>时长</th>
						<th>更新时间</th>
					</tr>
				</thead>
				<tbody id="indexlearnplantbodyid">
					<tr>
						<td>无信息...</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
	</div>	
</div>
<!-- 详细内容弹框开始 -->
					<div class="modal fade" id="modal-container-7225200" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel" style="font-size: 16px;">
										详细信息
									</h4>
								</div>						  
								<div class="modal-body" style="font-size: 13px;height:468px;">
									<h4>
										<span id="x_title"></span>
									</h4>
									<div style="color:#666666;">
										<div>
										<br>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">计划时间：</p>
												</div>
												<div class="col-md-7 column">
													<p  class="p13-999"><span id="x_starttime"></span>~<span id="x_lendtime" ></span></p>
												</div>
											</div>
											<div class="col-md-5 column">
												<div class="col-md-6 column">
													<p class="navbar-right">时长：</p>
												</div>
												<div class="col-md-6 column">
													<p style="color:#999" id="x_ldaylong"></p>
												</div>
											</div>
											<div class="col-md-1 column"></div>
											<div class="col-md-5 column">
												<div class="col-md-5 column">
													<p class="navbar-right">更新时间：</p>
												</div>
												<div class="col-md-7 column">
													<p class="yellow" style="color:#999" id="x_updatetime"></p>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-12 column" style="border-top:1px solid #ccc">
										<br/>
										<div style="height: 200px;">
											<span>计划内容：</span><br><br>
											<div class="col-md-12 column">
											<p  id="x_content"></p>
											</div>
										</div>
										<div style="height: 50px;">
											<span>计划总结：</span><br><br>
											<div class="col-md-12 column">
											<p id="x_summarize"></p>
											</div>
										</div>
									</div>
								</div>	
							       </div>   								
								 </div>
							</div>
							<!-- 弹窗结束 -->
							</div>