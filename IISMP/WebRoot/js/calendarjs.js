$(document).ready(function() {
	var currentLangCode = 'zh-cn';
	
	// rerender the calendar when the selected option changes
	$('#lang-selector').on('change', function() {
		if (this.value) {
			currentLangCode = this.value;
			$('#calendar').fullCalendar('destroy');
			renderCalendar();
		}
	});
	
	function renderCalendar() {
		var event = "";
		//获取签到信息
		url11 = url + '/findattenrecordAction';
		$.ajax({   
			type:'POST', //用POST方式传输   
			url:url11,      //目标地址 
			dataType:'html',       
			data:{},
			cache:false,
			success:function(data) {
				alert(data);
				var str = eval("("+data+")");
				if(str.isempty){
					event = str.jsona;
				}
			},
			error:function(data){
				alert("操作失败，请刷新后重新操作！！");
			}
	    });
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			//defaultDate: '2016-11-11',
			lang: currentLangCode,
			buttonIcons: false, // show the prev/next text
			weekNumbers: false,
			editable: false,
			
			
			
			events: event
				/*[
				{
					title: '10月11日18:30~22:03',
					start: '2016-10-11'
				},
				{
					title: 'Long Event',
					start: '2016-10-11',
					end: '2016-10-17'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-11-12T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-06-16T16:00:00'
				},
				{
					title: 'Meeting',
					start: '2014-06-12T10:30:00',
					end: '2014-06-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2014-06-12T12:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2014-06-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://172.18.69.31:8888',
					start: '2014-06-28'
				}
			]*/
		});
	}
	
	renderCalendar();
});
