      const body = document.querySelector('body');
      const modal = document.querySelector('.modal');
      const btnlogin = document.getElementById('login');
      //var iconexit = document.querySelector('.inmodal_img');
      var exit = document.getElementById('exit');
      let  failresult = document.querySelector('.failresult');
      var id_value = document.getElementById('id');
      var pwd_value = document.getElementById('pwd');

      btnlogin.addEventListener('click', () => {

       modal.className='modalshow';
       console.log('로그인 버튼클릭');
      });
   //모달 종료
      exit.addEventListener('click',() =>{
        id_value.value = null;
        pwd_value.value = null;
        console.log('exit');
        modal.className='modal';
      });
     // 로그인 체크
      function logincheck() {
        fetch("http://localhost:8080/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            id: id_value.value,
            pwd: pwd_value.value,
          }),
        })
      .then((response) => response.json())
      .then((data) =>  {
       console.log(data);
       console.log(data.result);
       if(data.result =="Success") {
        window.location.href = "http://localhost:8080";
         failresult.innerHTML =null;
       } else { failresult.innerHTML = "회원 정보가 다릅니다.";}
       })
     }
     function enterkey(){
        if (window.event.keyCode == 13) {
                // 엔터키가 눌렸을 때
                logincheck();
             }
     }