table!{
    Inventory(item_id){
        item_id -> Integer,
        item_name -> Text,
        item_upc -> Integer,
        item_cost -> Double,
        item_count -> Integer,
        item_received -> Integer,
        item_sold -> Integer,
        item_onSale -> Bool,
        item_salePrice -> Double,
        item_taxable -> Bool,
    }
}

table!{
    Store_transaction(trans_id){
        trans_id -> Integer,
        trans_data -> Integer,
        trans_total -> Double,
    }
}

table!{
    Transaction_items(ti_id){
        ti_id -> Integer,
    }
}
