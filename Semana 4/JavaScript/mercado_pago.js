const express = require("express");
const app = require();
const cors = require("cors")
const mercadopago = require("mercadopago")
const path = require("path")

mercadopago.configure({
    access_token: "<ACCESS_TOKEN>"
})

app.use(express.urlencoded({extended: false}));
app.use(express.json())
app.use(express.static(path.join(__dirname, "../client")))
app.use(cors());

app.get("/", function (requestAnimationFrame,res){
    path.resolve(__dirname, "..", "client", "index.html")
})

app.post("/create_preference", (req, res) => {
    let preference = {
        items: [
            {
                title: req.body.description,
                unit_price: Number(req.body.price),
                quantity: Number(req.body.quantity)
            }
        ]
    }
})
