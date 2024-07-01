



function Search(){
    let query = document.getElementById("search").value;
    fetch("http://localhost:8080/api/products/search?q="+query)
    .then(function(data){
        return data.json();
    }).then(function(products){
        let body = document.getElementById("body");
        body.innerHTML="";
        for (const product of products) {
            console.log(product);
            appendData(product)
        }
    })
}

function appendData(product){
    let body = document.getElementById("body");
    let tr = document.createElement("tr");
    let td1 = document.createElement("td");
    td1.innerHTML = product.product_id;
    let td2 = document.createElement("td");
    td2.innerHTML = product.name;
    tr.appendChild(td1);
    tr.appendChild(td2);
    body.appendChild(tr);
}
