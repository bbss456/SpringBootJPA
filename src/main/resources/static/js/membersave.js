  //전송 체크
  window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');
      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          var s = document.getElementById('Rregistration_number2');
          var selvalue =s.options[s.selectedIndex].value;
          console.log(selvalue);
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
//자동 전화번호 입력 수정
     function autoHypenPhone(str){
             str = str.replace(/[^0-9]/g, '');
             var tmp = '';
             if( str.length < 4){
                 return str;
             }else if(str.length < 7){
                 tmp += str.substr(0, 3);
                 tmp += '-';
                 tmp += str.substr(3);
                 return tmp;
             }else if(str.length < 11){
                 tmp += str.substr(0, 3);
                 tmp += '-';
                 tmp += str.substr(3, 3);
                 tmp += '-';
                 tmp += str.substr(6);
                 return tmp;
             }else{
                 tmp += str.substr(0, 3);
                 tmp += '-';
                 tmp += str.substr(3, 4);
                 tmp += '-';
                 tmp += str.substr(7);
                 return tmp;
             }
             return str;
         }
//비밀 번호 체크 확인
    var pwdcheck = document.getElementById('pwdcheck')
    pwdcheck.addEventListener("keyup",  function(event)
    {
         var pwd = document.getElementById('pwd').value;
         var pwdcheck = document.getElementById('pwdcheck').value;

         if( pwd == pwdcheck){
         document.getElementById('pwdcheck').className = 'form-control' ;
         }
         else{
         document.getElementById('pwdcheck').className = 'form-control is-invalid' ;

         }
    });
