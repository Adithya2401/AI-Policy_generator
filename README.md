# AI Policy Generator

## Project Overview
AI Policy Generator is a React web application designed to help organizations generate customized policy documents related to AI ethics, data privacy, cybersecurity, and more. The app uses an AI backend to generate policy content based on user inputs and selected policy types. Users can also download the generated policies as PDF documents.

## Features
- Input your organization name, policy version, and effective date.
- Select from various predefined policy types like AI Ethics, Data Privacy, Cybersecurity, etc.
- Generate customized policy content using AI.
- View generated policies instantly in markdown format.
- Download policies as PDF files.
- Simple and user-friendly interface built with React and TailwindCSS.

## Technologies Used
- React for frontend UI development
- TailwindCSS for styling
- jsPDF for PDF generation
- ReactMarkdown for rendering markdown content
- Fetch API to communicate with backend AI service (assumed)

## Installation & Setup

### Prerequisites
- Node.js and npm installed
- Backend API service running or accessible (set `REACT_APP_API_URL` in `.env` file)

### Setup Steps

1. Clone the repository:
git clone https://github.com/yourusername/ai-policy-generator.git
cd ai-policy-generator

2. Install dependencies:
npm install

3. Create a `.env` file at the root and specify your API URL:
REACT_APP_API_URL=http://localhost:5000/api

4. Start the development server:
npm start

The app will be accessible at `http://localhost:3000`.

## Usage

- Enter your policy context or requirement in the prompt textarea.
- Select the desired policy type from the dropdown arrow located inside the prompt input on the right.
- Enter organization name, effective date, and version information.
- Click "Generate Policy" to get AI-generated policy content.
- Review the content and click "Download PDF" to save it.

## Folder Structure

## Contributing

Contributions are welcome! Please fork the repository, create a feature branch, and open a pull request with your improvements.

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please open an issue or contact the maintainer.




