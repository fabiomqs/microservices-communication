import express from "express";
//import checkToken from "./src/config/auth/checkToken.js";

import { connectMongoDb } from "./src/config/db/mongoDbConfig.js";
import { createInitialData } from "./src/config/db/initialData.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8092;

connectMongoDb();
createInitialData();

//app.use(checkToken);

app.get("/api/status", (req, res) => {
    return res.status(200).json({
        service: "Sales-API",
        status: "up",
        httpStatus: 200,
    });
});

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
});