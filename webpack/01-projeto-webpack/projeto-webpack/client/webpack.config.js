const path = require("path");

// Também seria uma boa soulução para criar arquivo minificado em prod:
// webpack  -p --config webpack.config.js

module.exports = {
    entry: './app-src/app.js',
    mode: process.env.NODE_ENV == null ? 'development' : process.env.NODE_ENV,
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname,'dist'),
        publicPath: "dist"
    },
    module:{
        rules: [
            {
                test: /\.js$/,
                exclude:/node_modules/,
                use: {
                    loader: 'babel-loader'
                }
            }
        ]
    }


}