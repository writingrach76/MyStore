#[macro_use] extern crate rocket;

#[get("/")]
fn index() -> &'static str {
    "Hello, world!"
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index, item])
}

#[get("/item/<id>")]
fn item(id:i32) -> i32 {
    12
}