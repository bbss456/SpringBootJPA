const oneitemPrice = document.getElementById('itemprice').innerText;

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