use rocket::serde::{Serialize};

#[derive(Queryable, Serialize, Clone)]
#[serde(crate="rocket::serde")]
pub struct Item{
    pub item_id: i32,
    pub item_name: String,
    pub item_upc: i32,
    pub item_cost: f64,
    pub item_count: i32,
    pub item_received: i32,
    pub item_sold: i32,
    pub item_onSale: bool,
    pub item_salePrice: f64,
    pub item_taxable: bool,
}

#[derive(Queryable)]
pub struct Transaction{
    pub trans_id: i32,
    pub trans_data: i32,
    pub trans_total: f64,
}

#[derive(Queryable)]
pub struct TransactionItem{
    pub ti_id: i32,
}
