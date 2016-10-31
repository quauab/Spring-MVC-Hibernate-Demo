$(document).ready(function(){
	interval = doInterval(dateTime,1);
	$('.delete-customer').on('click',function(){
		var id = $(this).data('id');
		var url = '/delete/'+id;
		if (confirm('Delete Project?')) {
			$.ajax({
				url: url,
				type: 'DELETE',
				success:function(result){
					console.log('Deleting Customer ...');
					window.location.href='/';
				},
				error:function(err) {
					console.log(err);
				}
			});
		}
	});

	$('.edit-customer').on('click', function(){
		$('#edit-customer_first_name').val($(this).data('first_name'));
		$('#edit-customer_last_name').val($(this).data('last_name'));
		$('#edit-customer_email').val($(this).data('email'));
		$('#edit-customer_id').val($(this).data('id'));
	});	
});