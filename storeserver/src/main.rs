#[macro_use] extern crate rocket;
#[macro_use] extern crate diesel;

use rocket_sync_db_pools::{
    //diesel, 
    database,
};

use rocket::serde::{
    //Serialize,
    json::Json,
};

/*#[derive(Serialize)]
struct ErrRes {
    msg: String;
}*/

#[database("store_database")]
struct StoreDbConn(diesel::SqliteConnection);

use diesel::prelude::*;

pub mod models;
pub mod schema;


#[get("/")]
fn index() -> &'static str {
    "Hello, world!"
}

#[launch]
fn rocket() -> _ {
    rocket::build()
        .attach(StoreDbConn::fairing())
        .mount("/", routes![index, item])
}

#[get("/item/<id>")]
async fn item(conn: StoreDbConn, id:i32) -> Result<Json<Vec<models::Item>>, String> {
    //use crate::models::Item;
    use crate::schema::Inventory::dsl::*;

    match conn.run(move |c| Inventory.filter(item_id.eq(id)).load::<models::Item>(c)).await {
        Ok(r) => Ok(Json(r)),
        Err(e) => Err(e.to_string()),
    }
}
