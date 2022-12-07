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
    let itemid = document.getElementById('itemId');
    var userId = document.getElementById('userId');
    var gameToken = document.getElementById('gameToken');
    let itemPrice = document.getElementById('itemprice');
    let itemCount = document.getElementById('ItemCount');


    console.log(userId.value);

    if(userId.value == "") {
        alert("로그인 부탁 드립니다.");
    }
       fetch("http://localhost:8080/api/item/order", {
         method: "POST",
         headers: {
           "Content-Type": "application/json",
         },
         body: JSON.stringify({
            "memberId" : userId.value,
            "itemId": itemid.value,
            "itemPrice" : itemPrice.value,
            "itemCount" :itemCount.value,
            "city" : "인천",
            "street" : "부평구 십정동",
            "String" : "2150"
         }),
       })
     .then((response) => response.json())
     .then((data) =>  {
      console.log(data);
      })
}
