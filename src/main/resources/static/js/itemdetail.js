const oneitemPrice = document.getElementById('itemprice').innerText;
let itemOrder = document.getElementById('oneitemPrice');
function count(button) {
    let itemPrice = document.getElementById('itemprice');
    let itemCount = document.getElementById('ItemCount');
    if(button=="plus") {
        let Count = Number(itemCount.innerText) + 1;
        itemCount.innerText = Count;

        itemPrice.innerText = Number(itemPrice.innerText) + Number(oneitemPrice);
    }
    else{
         let Count = Number(itemCount.innerText) - 1;
         let Price = Number(itemPrice.innerText) - Number(oneitemPrice);
         Count = checkZero(Count);
         if (Count == 1) {
            Price = oneitemPrice;
         }
         itemCount.innerText = Count;
         itemPrice.innerText = Price;
    }
}

function checkZero(Count){
    let returnCount;
    if(Number(Count) <= 1) {
        returnCount = 1;
    }
    else{
        returnCount = Count;
    }
    return returnCount;
}


function orderItem() {
gameToken
    let itemid = document.getElementById('itemId').value;
    var userId = document.getElementById('userId');
    var gameToken = document.getElementById('gameToken');
    console.log(userId);
    console.log(userId.value);

//.elements;
//        fetch("http://localhost:8080/login", {
//          method: "POST",
//          headers: {
//            "Content-Type": "application/json",
//          },
//          body: JSON.stringify({
//            id: id_value.value,
//            pwd: pwd_value.value,
//          }),
//        })
//      .then((response) => response.json())
//      .then((data) =>  {
//       console.log(data);
//       console.log(data.result);
//       if(data.result =="Success") {
//        window.location.href = "http://localhost:8080";
//         failresult.innerHTML =null;
//       } else { failresult.innerHTML = "회원 정보가 다릅니다.";}
//       })
     }
