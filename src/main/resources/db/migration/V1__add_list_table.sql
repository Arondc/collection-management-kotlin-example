CREATE TABLE IF NOT EXISTS COLLECTION_LIST
(
    ID UUID NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
    NAME VARCHAR(80)
);