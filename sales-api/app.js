import express from "express";
//import checkToken from "./src/config/auth/checkToken.js";

import { connectRabbitMq } from "./src/config/rabbitmq/rabbitConfig.js";

import { connectMongoDb } from "./src/config/db/mongoDbConfig.js";
import { createInitialData } from "./src/config/db/initialData.js";
// import { sendMessageToProductStockUpdateQueue } from "./src/modules/product/rabbitmq/productStockUpdateSender.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8092;

connectMongoDb();
createInitialData();
connectRabbitMq();

//app.use(checkToken);

// app.get("/teste/:msg", (req, res) => {
//     const { msg } = req.params;
//     console.info(msg);
//     try {
//         sendMessageToProductStockUpdateQueue({"message": msg});
//         return res.status(200).json({status: 200});
//     } catch (err) {
//         console.error(err);
//         return res.status(500).json({error: true});
//     }
// });

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