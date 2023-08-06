
CREATE TABLE Brand (
    brandId INT PRIMARY KEY,
    brandName VARCHAR(255) NOT NULL
);


CREATE TABLE UserProfile (
    userProfileId INT PRIMARY KEY,
    userName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    registrationDate DATETIME NOT NULL
);

CREATE TABLE Cart (
    cartId INT PRIMARY KEY,
    userProfileId INT NOT NULL,
    quantity INT NOT NULL,
    addedToCartDate DATETIME NOT NULL,
    FOREIGN KEY (userProfileId) REFERENCES UserProfile(userProfileId)
);



CREATE TABLE Category (
    categoryId INT PRIMARY KEY,
    categoryType VARCHAR(100) NOT NULL
);



CREATE TABLE Color (
    colorId INT PRIMARY KEY,
    colorName VARCHAR(50) NOT NULL
);


CREATE TABLE SizeType (
    sizeTypeId INT PRIMARY KEY,
    sizeTypeName VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);


CREATE TABLE ItemSize (
    itemSizeId INT PRIMARY KEY,
    sizeTypeId INT NOT NULL,
    chestSize VARCHAR(20),
    waistSize VARCHAR(20),
    FOREIGN KEY (sizeTypeId) REFERENCES SizeType(sizeTypeId)
);




CREATE TABLE Seller (
    sellerId INT PRIMARY KEY,
    sellerName VARCHAR(100) NOT NULL
);




CREATE TABLE Wishlist (
    wishlistId INT PRIMARY KEY,
    userProfileId INT NOT NULL,
    FOREIGN KEY (userProfileId) REFERENCES UserProfile(userProfileId)
);



CREATE TABLE Product (
    productId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brandId INT NOT NULL,
    categoryId INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    colorId INT NOT NULL,
    itemSizeId INT NOT NULL,
    sku VARCHAR(50) NOT NULL,
    sellerId INT NOT NULL,
    lastUpdated DATETIME NOT NULL,
    FOREIGN KEY (brandId) REFERENCES Brand(brandId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId),
    FOREIGN KEY (colorId) REFERENCES Color(colorId),
    FOREIGN KEY (itemSizeId) REFERENCES ItemSize(itemSizeId),
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
);


CREATE TABLE Inventory (
    inventoryId INT PRIMARY KEY,
    quantity INT NOT NULL,
    productId INT NOT NULL,
    sellerId INT NOT NULL,
    lastUpdated DATETIME NOT NULL,
    FOREIGN KEY (productId) REFERENCES Product(productId),
    FOREIGN KEY (sellerId) REFERENCES Seller(sellerId)
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


