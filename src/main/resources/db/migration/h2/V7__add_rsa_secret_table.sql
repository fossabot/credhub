CREATE CACHED TABLE RSA_SECRET(
    PUBLIC_KEY VARCHAR(7000),
    ID BIGINT NOT NULL
);
ALTER TABLE RSA_SECRET ADD CONSTRAINT CONSTRAINT_1234 PRIMARY KEY(ID);
ALTER TABLE RSA_SECRET ADD CONSTRAINT RSA_SECRET_FKEY FOREIGN KEY(ID) REFERENCES NAMED_SECRET(ID) NOCHECK;