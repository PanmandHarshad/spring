
INSERT INTO Brand (brandId, brandName) VALUES (1, 'Nike');
INSERT INTO Brand (brandId, brandName) VALUES (2, 'Adidas');
INSERT INTO Brand (brandId, brandName) VALUES (3, 'Puma');
INSERT INTO Brand (brandId, brandName) VALUES (4, 'Reebok');
INSERT INTO Brand (brandId, brandName) VALUES (5, 'Under Armour');
INSERT INTO Brand (brandId, brandName) VALUES (6, 'New Balance');
INSERT INTO Brand (brandId, brandName) VALUES (7, 'Converse');
INSERT INTO Brand (brandId, brandName) VALUES (8, 'Vans');
INSERT INTO Brand (brandId, brandName) VALUES (9, 'Fila');
INSERT INTO Brand (brandId, brandName) VALUES (10, 'Skechers');


insert into Category (categoryId,  categoryType) VALUES (1, 'Pants');
insert into Category (categoryId,  categoryType) VALUES (2, 'Socks');
insert into Category (categoryId,  categoryType) VALUES (3, 'Caps');
insert into Category (categoryId,  categoryType) VALUES (4, 'Shoes');
insert into Category (categoryId,  categoryType) VALUES (5, 'Jackets');
insert into Category (categoryId,  categoryType) VALUES (6, 'T-Shirts');
insert into Category (categoryId,  categoryType) VALUES (7, 'Hats');
insert into Category (categoryId,  categoryType) VALUES (8, 'Shorts');
insert into Category (categoryId,  categoryType) VALUES (9, 'Gloves');
insert into Category (categoryId,  categoryType) VALUES (10, 'Belts');


INSERT INTO Color (colorId, colorName) VALUES (1, 'Red');
INSERT INTO Color (colorId, colorName) VALUES (2,'Blue');
INSERT INTO Color (colorId, colorName) VALUES (3,'Green');
INSERT INTO Color (colorId, colorName) VALUES (4,'Black');
INSERT INTO Color (colorId, colorName) VALUES (5,'White');
INSERT INTO Color (colorId, colorName) VALUES (6,'Gray');
INSERT INTO Color (colorId, colorName) VALUES (7,'Yellow');
INSERT INTO Color (colorId, colorName) VALUES (8,'Purple');
INSERT INTO Color (colorId, colorName) VALUES (9, 'Orange');
INSERT INTO Color (colorId, colorName) VALUES (10,'Pink');


INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (1,'Small', 'Fits small sizes');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (2,'Medium', 'Fits medium sizes');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (3,'Large', 'Fits large sizes');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (4,'XL', 'Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (5,'XXL', 'Double Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (6,'3XL', 'Triple Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (7,'4XL', 'Four Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (8,'5XL', 'Five Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (9,'6XL', 'Six Extra Large');
INSERT INTO SizeType (sizeTypeId, sizeTypeName, description) VALUES (10,'7XL', 'Seven Extra Large');


-- Assuming you have sizeTypeId values from SizeType table
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (1, 1, '40', '32');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (2, 2, '42', '34');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (3, 3, '44', '36');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (4, 4, '46', '38');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (5, 5, '48', '40');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (6, 6, '50', '42');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (7, 7, '52', '44');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (8, 8, '54', '46');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (9, 9, '56', '48');
insert into ItemSize (itemSizeId, sizeTypeId,  chestSize, waistSize) VALUES (110, 10, '58', '50');


insert into Seller (sellerId, sellerName) VALUES (1, 'ABC Seller');
insert into Seller (sellerId, sellerName) VALUES (2, 'XYZ Seller');
insert into Seller (sellerId, sellerName) VALUES (3, 'Best Deals Seller');
insert into Seller (sellerId, sellerName) VALUES (4, 'Sports Zone');
insert into Seller (sellerId, sellerName) VALUES (5, 'Fashion Trend');
insert into Seller (sellerId, sellerName) VALUES (6, 'Urban Styles');
insert into Seller (sellerId, sellerName) VALUES (7, 'Streetwear Mart');
insert into Seller (sellerId, sellerName) VALUES (8, 'Active Wear Co.');
insert into Seller (sellerId, sellerName) VALUES (9, 'Outdoor Gear');
insert into Seller (sellerId, sellerName) VALUES (10, 'Casual Vibes');


-- Assuming you have brandId, categoryId, colorId, sizeId, and sellerId values
INSERT INTO Product (productId, name, brandId, categoryId, price, colorId, itemSizeId, sku, sellerId, lastUpdated)
VALUES (1, 'Cool T-Shirt', 1, 1, 29.99, 1, 1, 'SKU123', 1, CURDATE());
INSERT INTO Product (productId, name, brandId, categoryId, price, colorId, itemSizeId, sku, sellerId, lastUpdated)
VALUES (2, 'Sport Pants', 2, 2, 39.99, 2, 2, 'SKU456', 2, CURDATE());
-- Add more product entries as needed


INSERT INTO UserProfile (userProfileId, userName, email, password, registrationDate)
VALUES (1, 'JohnDoe', 'john@example.com', 'password123', CURDATE());
INSERT INTO UserProfile (userProfileId, userName, email, password, registrationDate)
VALUES (2, 'JaneSmith', 'jane@example.com', 'password456', CURDATE());
-- Add more user entries as needed



-- Assuming you have userId and productId values
INSERT INTO Cart (cartId, userProfileId, quantity, addedToCartDate) VALUES (1, 1, 2, CURDATE());
INSERT INTO Cart (cartId, userProfileId, quantity, addedToCartDate) VALUES (2, 2, 1, CURDATE());
-- Add more cart entries as needed


-- Assuming you have userId values
INSERT INTO Wishlist (wishListId, userProfileId) VALUES (1, 1);
INSERT INTO Wishlist (wishListId, userProfileId) VALUES (2, 2);
-- Add more wishlist entries as needed
