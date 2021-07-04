use rocket::serde::{Serialize};

#[derive(Queryable, Serialize)]
#[serde(crate="rocket::serde")]
pub struct Item{
    pub item_id: i32,
    pub item_name: String,
    pub item_upc: i32,
    pub item_cost: f64,
    pub item_count: i32,
    pub item_recieved: i32,
    pub item_sold: i32,
    pub item_onSale: bool,
    pub item_salePrice: f64,
    pub item_taxable: bool,
}
