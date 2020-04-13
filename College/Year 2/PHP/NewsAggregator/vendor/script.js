function add_invitee_form()
{
	$('#dynamic_guest').html('');
	var str = '';
	var guests = $('#guests').val();
	
	for(var i=1;i<=guests;i++)
	 	str += '<div class="row"><div class="col-md-8 offset-md-2"><div class="row"><div class="col-md-4"><label>Name'+i+'</lable></div><div class="col-md-6"><input type="text" name="name'+i+'" class="form-control" required></div></div></div></div> <div class="row"><div class="col-md-8 offset-md-2"><div class="row"><div class="col-md-4"><label>Vegetarain'+i+'</lable></div><div class="col-md-3"><input type="checkbox" name="veg'+i+'">&nbsp;&nbsp;vegetarain</div></div></div></div>';

	$('#dynamic_guest').html(str);
}