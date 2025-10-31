import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import { GoogleGenerativeAI } from "@google/generative-ai";

dotenv.config(); // Loads .env file
const app = express();
app.use(cors());
app.use(express.json());

const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

app.post("/generate", async (req, res) => {
  try {
    const { prompt } = req.body;
    if (!prompt) {
      return res.status(400).json({ error: "Prompt is required" });
    }

    const model = genAI.getGenerativeModel({ model: "gemini-2.5-flash" });

    const result = await model.generateContent(prompt);

    const textResponse =
      result.response?.candidates?.[0]?.content?.parts?.[0]?.text ||
      result.response?.text() ||
      "No response from Gemini";

    res.json({ response: textResponse });
  } catch (error) {
    console.error("Gemini API error:", error);
    res.status(500).json({ error: error.message });
  }
});


app.listen(5000, () => {
  console.log("✅ Server running on port 5000");
});
