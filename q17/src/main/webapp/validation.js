function ValidateForm(frm){
       if (frm.firstname.value == ""){
          alert('First name is required.');
          frm.firstname.focus();
          return false;
       }
       if (frm.lastname.value == ""){
          alert('Last name is required.');
          frm.lastname.focus();
          return false;
       }
       if (frm.mail.value == ""){
          alert('Email address is required.');
          frm.mail.focus();
          return false;
       }
       if (frm.mail.value.indexOf("@") < 1 || frm.mail.value.indexOf(".") < 1){
          alert('Please enter a valid email address.');
          frm.mail.focus();
          return false;
       }
       if (frm.Position.value == ""){
          alert('Position is required.');
          frm.Position.focus();
          return false;
       }
       if (frm.phone.value == ""){
          alert('Phone is required.');
          frm.phone.focus();
          return false;
       }
       return true;
}

