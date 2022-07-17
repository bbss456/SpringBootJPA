  //전송 체크
  window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');
      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          var s = document.getElementById('Rregistration_number2');
          var selvalue =s.options[s.selectedIndex].value;
          var id = document.getElementById('name');
          var name = document.getElementById('nickname');
          var pwd = document.getElementById('pwd');
          var year = document.getElementById('Rregistration_number1');
          var month = document.getElementById('Rregistration_number2');
          var day = document.getElementById('Rregistration_number3');
          var email = document.getElementById('email');
          var city = document.getElementById('city');
          var street = document.getElementById('street');
          var zipcode = document.getElementById('zipcode');
          var phone = document.getElementById('phone');

          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          else if (form.checkValidity() === true) {
//             fetch("http://localhost:8080/post-membersave", {
//                       method: "POST",
//                       headers: {
//                         "Content-Type": "application/json",
//                       },
//                         body: JSON.stringify({
//                             id: id.value,
//                             name : name.value,
//                             pwd : pwd.value,
//                             year : year.value,
//                             month : month.value,
//                             day : day.value,
//                             email : email.value,
//                             city : city.value,
//                             street : street.value,
//                             zipcode : zipcode.value,
//                             phone : phone.value
//                        }),
//                     })
//                    .then(response => response.json())
//                    .then(response => {
//                       if(res.statusCode == 200) {
//                         console.log("회원 가입 정보 전송 완료");
//                         location.href = "http://localhost:8080/";
//                         alert("Success");
//                       }
//                     });
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
