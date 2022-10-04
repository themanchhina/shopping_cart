### Manual Tests
```
curl -vvv -X POST "http://localhost:8080/api/v1/cart" -H  "accept: application/json"

curl -vvv -X GET "http://localhost:8080/api/v1/cart/1" -H  "accept: application/json"   

curl --location --request POST 'http://localhost:8080/api/v1/cart/1/item' \                                                                                               ✔ 
--header 'Content-Type: application/json' \
--data-raw '{
    "price": 10,
    "content": "item1"
}'

curl -vvv -X PATCH  "http://localhost:8080/api/v1/item/7" -H  "accept: application/json"
```