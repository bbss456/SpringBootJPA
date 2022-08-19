//원 , 금액 처리
function inputNumberFormat(obj) {
     obj.value = comma(uncomma(obj.value));
 }

 function comma(str) {
     str = String(str);
     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
 }

 function uncomma(str) {
     str = String(str);
     return str.replace(/[^\d]+/g, '');
 }



var fileNo = 0;
var filesArr = new Array();

var file_list=document.getElementById('file_list');

/* 첨부파일 추가 */
function addFile(obj){
    console.log(obj);
    var attFileCnt = document.querySelectorAll('.filebox').length;    // 기존 추가된 첨부파일 개수
        var maxFileCnt = 10;   // 첨부파일 최대 개수
    var remainFileCnt = maxFileCnt - attFileCnt;    // 추가로 첨부가능한 개수
    var curFileCnt = obj.files.length;  // 현재 선택된 첨부파일 개수


    for (var i = 0; i < curFileCnt; i++) {

        const file = obj.files[i];
        console.log(file.name);

        // 첨부파일 검증
        if (validation(file)) {
            console.log(file_list);
            // 목록 추가
            let htmlData = '';
            htmlData += '<div id="file' + fileNo + '" class="filebox">';
            htmlData += '   <span class="name">' + file.name + '</span>';
            htmlData += '   <a class="delete" onclick="deleteFile(' + fileNo + ');"><img class="glyphicon glyphicon-remove-circle" src="https://img.icons8.com/fluency-systems-filled/344/circled-x.png"></img></a>';
            htmlData += '</div>';
            file_list.innerHTML += htmlData;
            fileNo++;
        }

    }

}

/* 첨부파일 검증 */
function validation(obj){

    const fileTypes = ['image/gif', 'image/jpeg', 'image/png', 'image/bmp', 'image/tif'];
    if (obj.name.length > 100) {
        alert("파일명이 100자 이상인 파일은 제외되었습니다.");
        return false;
    } else if (obj.size > (100 * 1024 * 1024)) {
        alert("최대 파일 용량인 100MB를 초과한 파일은 제외되었습니다.");
        return false;
    } else if (obj.name.lastIndexOf('.') == -1) {
        alert("확장자가 없는 파일은 제외되었습니다.");
        return false;
    } else if (!fileTypes.includes(obj.type)) {
        alert("첨부가 불가능한 파일은 제외되었습니다.");
        return false;
    } else {
        return true;
    }
}

/* 첨부파일 삭제 */
function deleteFile(num) {
    document.querySelector("#file" + num).remove();
}

function itemsend(){
  //document.getElementById('name').className +=' nullinput';
  let name = document.getElementById('name');
  let price = document.getElementById('price');
  let count = document.getElementById('itemscount');
  let content = document.getElementById('content');
  let category = document.getElementById('category');
  let fileUpload = document.querySelector('input[type="file"]');
  let errormsg ='';
  let fileNameList='';
  let formData = new FormData(); //fetch api data
  formData.append('name', name.value);
  formData.append('price', price.value);
  formData.append('itemscount', count.value);
  formData.append('category', category.value);


  for (let key of formData.keys()) {
      //필수 값 구별
       if(formData.get(key)==null || formData.get(key)==undefined || formData.get(key)==''){
        document.getElementById(key).className +=' nullinput' ;
        errormsg = 'error';
       }
       else if(formData.get(key)=='카테고리 선택'){
       document.getElementById(key).className +=' nullinput' ;
       errormsg = 'error';
       }
       else {
        document.getElementById(key).className = 'form-control';
       }
    }
    if(errormsg=='error'){
     alert("필수항목을 입력하세요");
    }else{

      //전송할  파일 개수
      let filecount = fileUpload.files.length - 1;

      for(var i =0; i < fileUpload.files.length; i++) {
        let fileobj = fileUpload.files[i];
        formData.append("file_"+i, fileobj); // 실제 데이터

        fileNameList += "file_"+i;
        if(filecount !=i){
         fileNameList +='@';
        }
      }

    formData.append('fileNameList', fileNameList);
    formData.append('content', content.value);   //  필수 값 아닌 값 추가

    fetch("http://localhost:8080/api/itemregister", {
      method: "POST",
      body: formData,
     })
    .then((response) => response.json())
    .then((data) => {
     if(data.result =='성공') {
          console.log(data.result);
          alert("상품등록이 완료되었습니다.");
          window.location.replace("http://localhost:8080/itemregister");
     }else{
        alert("상품등록 실패하였습니다.");
        window.location.replace("http://localhost:8080/itemregister");
      }
     })
    }
}

