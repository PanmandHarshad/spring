create database ecommercemarket;

CREATE TABLE Brand (
    brandId INT PRIMARY KEY AUTO_INCREMENT,
    brandName VARCHAR(255) NOT NULL
);


CREATE TABLE Category (
    categoryId INT PRIMARY KEY AUTO_INCREMENT,
    categoryType VARCHAR(255) NOT NULL
);


CREATE TABLE Color (
    colorId INT PRIMARY KEY AUTO_INCREMENT,
    colorName VARCHAR(255) NOT NULL
);


CREATE TABLE SizeType (
    sizeTypeId INT PRIMARY KEY AUTO_INCREMENT,
    sizeTypeName VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);


CREATE TABLE Size (
    sizeId INT PRIMARY KEY AUTO_INCREMENT,
    chestSize VARCHAR(255),
    waistSize VARCHAR(255),
    sizeTypeId INT NOT NULL,
    FOREIGN KEY (sizeTypeId) REFERENCES SizeType(sizeTypeId)
);


CREATE TABLE Seller (
    sellerId INT PRIMARY KEY AUTO_INCREMENT,
    sellerName VARCHAR(255) NOT NULL
);


CREATE TABLE Inventory (
    inventoryId INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT,
    productId INT NOT NULL,
    sellerId INT NOT NULL,
    lastUpdated DATETIME NOT NULL,
    FOREIGN KEY (productId) REFERENCES Product(productId),
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
);


CREATE TABLE Product (
    productId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    brandId INT NOT NULL,
    categoryId INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    colorId INT NOT NULL,
    sizeId INT NOT NULL,
    sku VARCHAR(255) NOT NULL,
    sellerId INT NOT NULL,
    lastUpdated DATETIME NOT NULL,
    FOREIGN KEY (brandId) REFERENCES Brand(brandId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId),
    FOREIGN KEY (colorId) REFERENCES Color(colorId),
    FOREIGN KEY (sizeId) REFERENCES Size(sizeId),
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
);


CREATE TABLE User (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    registrationDate DATETIME NOT NULL
);


CREATE TABLE Cart (
    cartId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    quantity INT NOT NULL,
    addedToCartDate DATETIME NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId)
);


CREATE TABLE Wishlist (
    wishlistId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId)
);


CREATE TABLE Cart_Product (
    cartId INT NOT NULL,
    productId INT NOT NULL,
    PRIMARY KEY (cartId, productId),
    FOREIGN KEY (cartId) REFERENCES Cart(cartId),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);


CREATE TABLE Wishlist_Product (
    wishlistId INT NOT NULL,
    productId INT NOT NULL,
    PRIMARY KEY (wishlistId, productId),
    FOREIGN KEY (wishlistId) REFERENCES Wishlist(wishlistId),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);
