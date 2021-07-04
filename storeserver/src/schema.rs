table!{
    Inventory(item_id){
        item_id -> Integer,
        item_name -> Text,
        item_upc -> Integer,
        item_cost -> Double,
        item_count -> Integer,
        item_recieved -> Integer,
        item_sold -> Integer,
        item_onSale -> Bool,
        item_salePrice -> Double,
        item_taxable -> Bool,
    }
}
