const { Model, Sequelize, DataTypes } = require('sequelize');
const config = null;

class Admin extends Model {}
Admin.init(
    {
        name: {
            type: DataTypes.STRING,
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
        modelName: 'Admin',
        underscored: true,
        tableName: 'admin',
        paranoid: true
    }
);

module.exports = Admin;