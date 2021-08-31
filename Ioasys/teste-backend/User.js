const { Model, Sequelize, DataTypes } = require('sequelize');
const config = null;

class User extends Model {}
User.init(
    {
        name: {
            type: DataTypes.STRING,
            allowNull: false
        },
        age: {
            type: DataTypes.NUMBER,
            allowNull: false
        },
        email: {
            type: DataTypes.STRING,
            allowNull: false
        },
        password: {
            type: DataTypes.STRING,
            allowNull: false
        }
    },
    {
        sequelize: new Sequelize(config),
        modelName: 'User',
        underscored: true,
        tableName: 'user',
        paranoid: true
    }
);

module.exports = User;