# Rentalit
A rental service website that customers can post goods for rent, and also select goods to rent.  This service will keep track of customers, the different objects for rent, and if they are available or in use currently.  We will set this up for a few types of goods initially, and branch out to more, given time.


## Dev Notes on setting up local MongoDB
**1.** Ensure MongoDB is installed (since we all use macs):
```
brew update
brew install mongodb
```

**2.** Create a data directory (Default is /data/db):
```
mkdir -p /data/db
```

**3.** make sure read/write permissions are set:
```
sudo chown -R $USER /data/db
```
**4.** Run a mongod instance via:
```
mongod
```
Then you can open up an interactive mongo shell using the command: ```mongo```. Note that you do need an instance live when running intellij in order to connect to the database successfully.
